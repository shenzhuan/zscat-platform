package com.zscat.label.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.zscat.common.constants.ZKServicePathConstants;
import com.zscat.common.utils.ZKConfig;
import com.zscat.common.utils.ZkUtils;
import com.zscat.label.dao.LabelRelationMapper;
import com.zscat.label.entity.Label;
import com.zscat.label.entity.LabelRelation;
import com.zscat.label.entity.LabelRelationVO;
import com.zscat.label.entity.LabelVO;
import com.zscat.label.enums.LabelRelationTypeEnum;
import com.zscat.label.service.LabelRelationService;
import com.zscat.label.service.LabelService;
import com.zscat.label.utils.CommonUtils;
import com.zscat.label.utils.LabelUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @author: zscat
 * @date: 2018/7/10
 * @Description: TODO
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "${label.service.version}",
        application = "${dubbo.application.id}",
        registry = "${dubbo.registry.id}"
)
@Log4j2
public class LabelRelationServiceImpl implements LabelRelationService {
    @Resource
    private LabelRelationMapper labelRelationMapper;

    @Resource
    private LabelService labelService;

    @Resource
    private RedisTemplate<String, List<LabelVO>> redisTemplate;

    @Value("${dubbo.registry.servers}")
    private String zkSerers;

    @Value("${dubbo.registry.sessionTimeoutMs}")
    private int zkSessionTimeoutMs;

    @Value("${dubbo.registry.connectionTimeoutMs}")
    private int zkConnectionTimeoutMs;

    @Value("${dubbo.registry.syncTimeMs}")
    private int zkSyncTimeMs;

    @PostConstruct
    public void init() {
        ZKConfig zkConfig = new ZKConfig(ZKServicePathConstants.ZK_CONFIG_ROOT, zkSerers, zkSessionTimeoutMs, zkConnectionTimeoutMs, zkSyncTimeMs, true);
        ZkUtils.setZkConfig(zkConfig);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public Integer countByLabelIds(LabelRelationVO vo) {
        return containsLabelIds(vo).size();
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<Integer> containsLabelIds(LabelRelationVO vo) {
        List<Integer> result = Lists.newArrayList();

        List<Integer> labelIds = vo.getLabelIds();
        List<Integer> relationIds = vo.getRelationIds();
        Integer relationType = vo.getRelationType();

        // 循环判断relationId是否包含labelIds
        for (Integer relationId : relationIds) {
            boolean flag = true;

            // 当前relationId对应的标签列表
            LabelRelationVO labelRelationVO = new LabelRelationVO();
            labelRelationVO.setRelationId(relationId);
            labelRelationVO.setRelationType(relationType);
            List<LabelVO> labelVOS = getLabelByRelationId(labelRelationVO);
            Set<Integer> labelVOIds = Sets.newHashSetWithExpectedSize(labelVOS.size());
            for (LabelVO labelVO : labelVOS) {
                labelVOIds.add(labelVO.getLabelId());
            }

            // 判断relationId是否包含labelIds
            for (Integer labelId : labelIds) {
                if (!labelVOIds.contains(labelId)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result.add(relationId);
            }
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addLabelRelation(LabelRelation labelRelation) {
        LabelRelationVO vo = new LabelRelationVO();
        vo.setRelationType(labelRelation.getRelationType());
        vo.setRelationIds(Lists.newArrayList(labelRelation.getLabelId()));
        addLabelRelation(vo);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addLabelRelation(LabelRelationVO vo) {
        List<Integer> relationIds = vo.getRelationIds();
        Integer labelId = vo.getLabelId();
        Integer relationType = vo.getRelationType();

        if (relationIds == null || relationIds.size() <= 0) {
            throw new IllegalArgumentException("relationIds为null或size为0. relationIds: " + relationIds);
        }
        Preconditions.checkNotNull(labelId);
        Preconditions.checkNotNull(relationType);

        Label label = labelService.getLabelById(labelId);
        if (label == null) {
            throw new RuntimeException("label为null! labelId: " + labelId);
        }
        List<LabelRelation> all = labelRelationMapper.findAllLabelRelation();
        Map<String,LabelRelation> relationMap = new HashMap<>();
        for (LabelRelation l : all){
            relationMap.put(l.getLabelId()+"-"+l.getRelationType()+"-"+l.getRelationId()+"",l);
        }
        List<LabelRelation> labelRelations = Lists.newArrayList();
        List<LabelRelation> tmpLabelRelations = Lists.newArrayListWithCapacity(1000);
        Set<Integer> relationSet = Sets.newHashSet(relationIds);
        for (Integer relationId : relationSet) {
            // 如果已经有该记录，则不添加
          //  Integer count = labelRelationMapper.countLabelRelation(relationId, labelId, relationType);
            LabelRelation ll = relationMap.get(labelId+"-"+relationType+"-"+relationId+"");
            if (ll!=null) {
                continue;
            }

            LabelRelation labelRelation = new LabelRelation();
            labelRelation.setLabelId(label.getLabelId());
            labelRelation.setLabelName(label.getLabelName());
            labelRelation.setLabelPartition(label.getLabelPartition());
            labelRelation.setLabelGroupId(label.getLabelGroupId());
            labelRelation.setRelationId(relationId);
            labelRelation.setRelationType(relationType);

            labelRelations.add(labelRelation);
            tmpLabelRelations.add(labelRelation);
            if (tmpLabelRelations.size() >= 1000) {
                labelRelationMapper.batchInsert(tmpLabelRelations);
                tmpLabelRelations.clear();
            }
        }

        if (tmpLabelRelations.size() > 0) {
            labelRelationMapper.batchInsert(tmpLabelRelations);
        }

        if (labelRelations.size() > 0) {
            flushCache(labelRelations);
        }

        // 刷新饮食推荐服务的缓存
        if (relationType == LabelRelationTypeEnum.INGREDIENTS.getId()) {
            flushDietServiceIngreLabelCache();
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delLabelRelation(LabelRelation labelRelation) {
        LabelRelationVO vo = new LabelRelationVO();
        vo.setRelationType(labelRelation.getRelationType());
        vo.setRelationIds(Lists.newArrayList(labelRelation.getLabelId()));
        delLabelRelation(vo);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delLabelRelation(Integer relationType, Integer relationId) {
        labelRelationMapper.batchDelete(Lists.newArrayList(relationId), relationType, null);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delLabelRelation(LabelRelationVO vo) {
        List<Integer> relationIds = vo.getRelationIds();
        Integer labelId = vo.getLabelId();
        Integer relationType = vo.getRelationType();

        if (relationIds == null || relationIds.size() <= 0) {
            throw new IllegalArgumentException("relationIds为null或size为0. relationIds: " + relationIds);
        }
        Preconditions.checkNotNull(labelId);
        Preconditions.checkNotNull(relationType);

        Label label = labelService.getLabelById(labelId);
        if (label == null) {
            throw new RuntimeException("label为null! labelId: " + labelId);
        }

        List<LabelRelation> labelRelations = Lists.newArrayList();
        List<Integer> tmpRelationIds = Lists.newArrayListWithCapacity(1000);
        for (Integer relationId : relationIds) {
            tmpRelationIds.add(relationId);

            // 清除缓存
            LabelRelation labelRelation = new LabelRelation();
            labelRelation.setRelationId(relationId);
            labelRelation.setRelationType(relationType);
            labelRelation.setLabelId(labelId);
            labelRelations.add(labelRelation);

            if (tmpRelationIds.size() >= 1000) {
                labelRelationMapper.batchDelete(tmpRelationIds, relationType, labelId);
                tmpRelationIds.clear();
            }
        }

        if (tmpRelationIds.size() > 0) {
            labelRelationMapper.batchDelete(tmpRelationIds, relationType, labelId);
        }

        if (labelRelations.size() > 0) {
            flushCache(labelRelations);
        }

        // 刷新饮食推荐服务的缓存
        if (relationType == LabelRelationTypeEnum.INGREDIENTS.getId()) {
            flushDietServiceIngreLabelCache();
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<LabelVO> getLabelByRelationId(LabelRelationVO vo) {
        Integer relationId = vo.getRelationId();
        Integer relationType = vo.getRelationType();
        Preconditions.checkNotNull(relationId);
        Preconditions.checkNotNull(relationType);

        // cache
        String redisKey = LabelUtils.genRelationRedisKey(relationId, relationType);
        ValueOperations<String, List<LabelVO>> valueOperations = redisTemplate.opsForValue();
        List<LabelVO> labelVOS = valueOperations.get(redisKey);
        if (labelVOS != null) {
            return labelVOS;
        }

        // db
        List<LabelVO> result = Collections.emptyList();
        List<LabelRelation> labelRelations = labelRelationMapper.findByRelationId(relationId, relationType);

        if (CommonUtils.checkCollecitonNotEmpty(labelRelations)) {
            result = Lists.newArrayListWithCapacity(labelRelations.size());

            for (LabelRelation labelRelation : labelRelations) {
                Integer labelId = labelRelation.getLabelId();
                LabelVO labelVO= labelService.getLabelById(labelId);
                if (labelVO != null) {
                    result.add(labelVO);
                }
            }
        }

        valueOperations.set(redisKey, result, 1, TimeUnit.DAYS);
        return result;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<Integer> getLabelByRelationId(LabelRelation labelRelation) {
        List<Integer> result = Lists.newArrayListWithCapacity(0);

        LabelRelationVO vo = new LabelRelationVO();
        CommonUtils.copyProperties(labelRelation, vo);
        List<LabelVO> labelVOS = getLabelByRelationId(vo);
        if (CommonUtils.checkCollecitonNotEmpty(labelVOS)) {
            result = Lists.newArrayListWithCapacity(labelVOS.size());

            for (LabelVO labelVO : labelVOS) {
                result.add(labelVO.getLabelId());
            }
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<LabelRelationVO> getByRelationType(Integer relationType) {
        List<LabelRelation> labelRelations = labelRelationMapper.findByRelationTypeAndLabelIds(relationType, null);
        return transferList(labelRelations);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<LabelRelationVO> getLabeRelationlVOByRelationTypeAndLabelIds(LabelRelationVO vo) {
        Integer relationType = vo.getRelationType();
        List<Integer> labelIds = vo.getLabelIds();

        Preconditions.checkNotNull(relationType);

        List<LabelRelation> list = labelRelationMapper.findByRelationTypeAndLabelIds(relationType, labelIds);
        return transferList(list);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<Integer> getRelationIdByRelationTypeAndLabelIds(LabelRelationVO vo) {
        List<Integer> result = Lists.newArrayListWithCapacity(0);
        List<LabelRelationVO> labelRelationVOS = getLabeRelationlVOByRelationTypeAndLabelIds(vo);

        if (CommonUtils.checkCollecitonNotEmpty(labelRelationVOS)) {
            result = Lists.newArrayListWithCapacity(labelRelationVOS.size());

            for (LabelRelationVO labelRelationVO : labelRelationVOS) {
                result.add(labelRelationVO.getRelationId());
            }
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public LabelRelationVO getFitCampLabels(Integer userId) {
        LabelRelation labelRelation = labelRelationMapper.findEntity(userId, LabelRelationTypeEnum.USER.getId(), Lists.newArrayList(73, 74, 75, 76, 77, 78));

        if (labelRelation == null) {
            return null;
        }

        return transfer(labelRelation);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public LabelRelationVO getHotCampLabels(Integer userId) {
        LabelRelation labelRelation = labelRelationMapper.findEntity(userId, LabelRelationTypeEnum.USER.getId(), Lists.newArrayList(79, 80, 81, 82, 83, 84));

        if (labelRelation == null) {
            return null;
        }

        return transfer(labelRelation);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public LabelRelationVO getGroupLabels(Integer userId , List<Integer> labelIds ,Integer relationType ) {
        LabelRelation labelRelation = labelRelationMapper.findEntity(userId, relationType, labelIds);

        if (labelRelation == null) {
            return null;
        }

        return transfer(labelRelation);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public LabelRelationVO updateLabelRelation(LabelRelationVO vo) {
        Preconditions.checkNotNull(vo.getLabelRelationId());

        LabelRelation labelRelation = labelRelationMapper.selectByPrimaryKey(vo.getLabelRelationId());

        // 更新其他信息
        CommonUtils.copyProperties(vo, labelRelation);

        // 更新label信息
        Label label = labelService.getLabelById(vo.getLabelId());
        labelRelation.setLabelId(label.getLabelId());
        labelRelation.setLabelName(label.getLabelName());
        labelRelation.setLabelPartition(label.getLabelPartition());
        labelRelation.setLabelGroupId(label.getLabelGroupId());

        labelRelationMapper.updateByPrimaryKey(labelRelation);

        CommonUtils.copyProperties(labelRelation, vo);
        if (labelRelation!=null) {
            List<LabelRelation> relations = new ArrayList<>();
            relations.add(labelRelation);
            flushCache(relations);
        }

        // 刷新饮食推荐服务的缓存
        if (vo.getRelationType() == LabelRelationTypeEnum.INGREDIENTS.getId()) {
            flushDietServiceIngreLabelCache();
        }
        return vo;
    }

    /**
     * 根据条件查询关系列表
     * @param relationId
     * @return 关联关系列表
     */
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public LabelRelation findLabelRelation( Integer relationId,  Integer relationType,  Integer labelId){
        return labelRelationMapper.findLabelRelation(relationId,relationType,labelId);
    }
    /**
     * 刷新redis缓存
     * @param labelRelations 标签关系列表
     */
    private void flushCache(List<LabelRelation> labelRelations) {
        if (CommonUtils.checkCollecitonNotEmpty(labelRelations)) {
            for (LabelRelation labelRelation : labelRelations) {
                String redisKey = LabelUtils.genRelationRedisKey(labelRelation.getRelationId(), labelRelation.getRelationType());
                redisTemplate.delete(redisKey);

                // 刷新label缓存
                redisTemplate.delete(LabelUtils.genRedisKey(labelRelation.getLabelId()));
            }
        }
    }

    /**
     * 实体转换成VO
     * @param relations 实体列表
     * @return
     */
    private List<LabelRelationVO> transferList(List<LabelRelation> relations) {
        List<LabelRelationVO> labelRelationVOS = Lists.newArrayListWithCapacity(0);

        if (CommonUtils.checkCollecitonNotEmpty(relations)) {
            labelRelationVOS = Lists.newArrayListWithCapacity(relations.size());

            for (LabelRelation labelRelation : relations) {
                labelRelationVOS.add(transfer(labelRelation));
            }
        }

        return labelRelationVOS;
    }

    /**
     * 实体转换为VO
     * @param labelRelation 实体
     * @return VO
     */
    private LabelRelationVO transfer(LabelRelation labelRelation) {
        LabelRelationVO vo = new LabelRelationVO();
        CommonUtils.copyProperties(labelRelation, vo);

        return vo;
    }

    /**
     * 刷新饮食推荐服务的内存级别的缓存
     */
    private void flushDietServiceIngreLabelCache() {
        ZkUtils.updatePersistentPath(ZKServicePathConstants.ZK_CONFIG_ROOT + ZKServicePathConstants.DIET_INGREDIENTSLABEL_SERVICE_PATH, "1");
    }
}
