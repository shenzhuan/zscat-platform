package com.zscat.label.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.zscat.common.constants.ZKServicePathConstants;
import com.zscat.common.utils.ThreadPoolUtils;
import com.zscat.common.utils.ZkUtils;
import com.zscat.label.dao.LabelMapper;
import com.zscat.label.dao.LabelRelationMapper;
import com.zscat.label.entity.Label;
import com.zscat.label.entity.LabelRelation;
import com.zscat.label.entity.LabelVO;
import com.zscat.label.enums.*;
import com.zscat.label.service.LabelGroupService;
import com.zscat.label.service.LabelService;
import com.zscat.label.utils.CommonUtils;
import com.zscat.label.utils.LabelUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;

/**
 * @version V1.0
 * @author: zscat
 * @date: 2018/7/10
 * @Description: TODO
 */
@Service(
        version = "${label.service.version}",
        application = "${dubbo.application.id}",
        registry = "${dubbo.registry.id}"
)
@Log4j2
public class LabelServiceImpl implements LabelService {
    @Resource
    private LabelMapper labelMapper;

    @Resource
    private RedisTemplate<String, LabelVO> redisTemplate;

    @Resource
    private LabelRelationMapper labelRelationMapper;

    @Resource
    private LabelGroupService labelGroupService;

    @Resource
    private PlatformTransactionManager transactionManager;

    @PreDestroy
    public void destroy() {
        ThreadPoolUtils.shutdown();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LabelVO addLabel(LabelVO labelVO) {
        Preconditions.checkNotNull(labelVO);
        Preconditions.checkNotNull(labelVO.getLabelType());
        Preconditions.checkNotNull(labelVO.getLabelName());
        Preconditions.checkNotNull(labelVO.getLabelStatus());
        Preconditions.checkNotNull(labelVO.getIsUserShow());
        Preconditions.checkNotNull(labelVO.getLabelPartition());
        // 不是用户标签大类的groupId必传参数
        if (LabelPartitionEnum.USER_LABEL.getId() != labelVO.getLabelPartition()) {
            Preconditions.checkNotNull(labelVO.getLabelGroupId());
        }

        int maxWord = 30;
        if (labelVO.getLabelName().length() > maxWord) {
            throw new IllegalArgumentException("标签名称不超过30字符！");
        }

        maxWord = 100;
        if (labelVO.getRemark().length() > maxWord) {
            throw new IllegalArgumentException("备注不超过100字符！");
        }

        int rows = labelMapper.save(labelVO);

        // 每个【内容标签】和【兼容标签】被创建时，需自动创建5个【用户自动标签】
        if (LabelPartitionEnum.CONTENT_LABEL.getId() == labelVO.getLabelPartition()
                || LabelPartitionEnum.COMPATIBLE_LABEL.getId() == labelVO.getLabelPartition()) {
            // 不感兴趣
            Label label = new Label();
            CommonUtils.copyProperties(labelVO, label);
            label.setLabelPartition(LabelPartitionEnum.USER_LABEL.getId());
            label.setLabelId(null);
            label.setLabelGroupId(null);
            label.setLabelType(LabelTypeEnum.AUTO.getId());
            label.setLabelName(labelVO.getLabelName() + "不感兴趣");
            label.setParentId(labelVO.getLabelId());
            label.setRemark("1");
            labelMapper.save(label);

            // 轻度偏好
            Label label2 = new Label();
            CommonUtils.copyProperties(label, label2);
            label2.setLabelPartition(LabelPartitionEnum.USER_LABEL.getId());
            label2.setLabelId(null);
            label2.setLabelName(labelVO.getLabelName() + "轻度偏好");
            label2.setRemark("2");
            labelMapper.save(label2);

            // 中度偏好
            Label label3 = new Label();
            CommonUtils.copyProperties(label, label3);
            label3.setLabelId(null);
            label3.setLabelPartition(LabelPartitionEnum.USER_LABEL.getId());

            label3.setLabelName(labelVO.getLabelName() + "中度偏好");
            label3.setRemark("3");
            labelMapper.save(label3);

            // 重度偏好
            Label label4 = new Label();
            CommonUtils.copyProperties(label, label4);
            label4.setLabelId(null);
            label4.setLabelPartition(LabelPartitionEnum.USER_LABEL.getId());

            label4.setLabelName(labelVO.getLabelName() + "重度偏好");
            label4.setRemark("4");
            labelMapper.save(label4);

            // 反感
            Label label5 = new Label();
            CommonUtils.copyProperties(label, label5);
            label5.setLabelId(null);
            label5.setLabelPartition(LabelPartitionEnum.USER_LABEL.getId());

            label5.setLabelName(labelVO.getLabelName() + "反感");
            label5.setRemark("5");
            labelMapper.save(label5);
        }

        if (rows > 0) {
            return labelVO;
        }

        return null;
    }

    @Override
    public LabelVO updateLabel(Label label) {
        Preconditions.checkNotNull(label);

        LabelVO vo = getLabelById(label.getLabelId());

        // 校验标签是否能被修改
        if (LabelUtils.isAutoLabel(label)) {
            throw new RuntimeException("自动标签不能修改！labelId: " + vo.getLabelId());
        }

        if (LabelStatusEnum.ENABLE.getId() == vo.getLabelStatus()) {
            throw new RuntimeException("标签为激活状态不能修改！labelId: " + vo.getLabelId());
        }

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            labelMapper.update(label);
            transactionManager.commit(status);

            flushCache(Lists.newArrayList(label.getLabelId()));
            flushDietServiceCache();
            return getLabelById(label.getLabelId());
        } catch (Exception e) {
            transactionManager.rollback(status);
            log.info("updateLabel error!", e);
        }

        return null;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<LabelVO> list(LabelVO labelVO) {
        List<LabelVO> result = Lists.newArrayListWithCapacity(0);

        List<Label> list = labelMapper.listByPage(labelVO);
        if (CommonUtils.checkCollecitonNotEmpty(list)) {
            result = Lists.newArrayListWithCapacity(list.size());

            for (Label label : list) {
                result.add(transfer(label));
            }
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public long listCount(LabelVO labelVO) {
        return labelMapper.countByPage(labelVO);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<LabelVO> listByGroup(Integer labelGroupId) {
        List<LabelVO> result = Collections.emptyList();

        List<Label> list = labelMapper.findByLabelGroupId(labelGroupId);
        if (list != null && list.size() > 0) {
            result = Lists.newArrayListWithCapacity(list.size());
            for (Label label : list) {
                result.add(simpleTransfer(label));
            }
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public LabelVO getLabelById(Integer labelId) {
        Preconditions.checkNotNull(labelId);
        LabelVO labelVO = null;

                // redis 缓存
//        String redisKey = LabelUtils.genRedisKey(labelId);
//        ValueOperations<String, LabelVO> valueOperations = redisTemplate.opsForValue();
//        LabelVO labelVO = valueOperations.get(redisKey);
//        if (labelVO != null) {
//            return labelVO;
//        }

        // DB
        Label label = labelMapper.findById(labelId);
        if (label != null) {
            labelVO = transfer(label);

            // redis 缓存
            //valueOperations.set(redisKey, labelVO, 1, TimeUnit.DAYS);
            return labelVO;
        }

        return null;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public LabelVO getCurrentSeasonLabel(String labelName) {
        Preconditions.checkNotNull(labelName);

        List<Label> labels = labelMapper.getCurrentSeasonLabel(labelName);
        Label label = null != labels ? labels.get(0) : null;

        if (label != null) {
            return transfer(label);
        }

        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delLabel(List<Integer> labelIds) {
        if (labelIds != null && labelIds.size() > 0) {
            for (Integer labelId : labelIds) {
                LabelVO vo = getLabelById(labelId);

                // 自动标签不能删除
                if (LabelUtils.isAutoLabel(vo)) {
                    throw new RuntimeException("自动标签不能删除！labelId: " + vo.getLabelId());
                }

                // 被使用的标签不能删除
                if (vo.getIngredientsRelationNum() > 0
                        || vo.getUserRelationNum() > 0
                        || vo.getMarketingRelationNum() > 0) {
                    throw new RuntimeException("标签已被使用，不能删除！labelId: " + vo.getLabelId());
                }
                // 删除子标签
               /* List<Label> childs = labelMapper.findByParentId(labelId);
                if (childs != null && childs.size() > 0) {
                    for (Label label : childs) {
                        labelIds.add(label.getLabelId());
                    }
                }*/
            }

            labelMapper.batchDelete(labelIds);
            flushCache(labelIds);
            flushDietServiceCache();
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean enableLabel(List<Integer> labelIds) {
        if (labelIds != null && labelIds.size() > 0) {
            labelMapper.updateStatus(labelIds, LabelStatusEnum.ENABLE.getId());
            flushCache(labelIds);
            flushDietServiceCache();
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean disableLabel(List<Integer> labelIds) {
        if (labelIds != null && labelIds.size() > 0) {
            for (Integer labelId : labelIds) {
                LabelVO vo = getLabelById(labelId);

                // 自动标签不能停用
                if (LabelUtils.isAutoLabel(vo)) {
                    throw new RuntimeException("自动标签不能停用！labelId: " + vo.getLabelId());
                }

                // 被使用的标签不能删除
                if (vo.getIngredientsRelationNum() > 0
                        || vo.getUserRelationNum() > 0
                        || vo.getMarketingRelationNum() > 0) {
                    throw new RuntimeException("标签已被使用，不能停用！labelId: " + vo.getLabelId());
                }
            }

            labelMapper.updateStatus(labelIds, LabelStatusEnum.DISABLE.getId());
            flushCache(labelIds);
            flushDietServiceCache();
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<LabelVO> searchLabel(String keyword, List<Integer> partitionIds, List<Integer> labelGroupIds) {
        List<LabelVO> result = Lists.newArrayListWithCapacity(0);
        List<Label> labels = labelMapper.findByKeyword(keyword, partitionIds, labelGroupIds, 0);

        if (labels != null && labels.size() > 0) {
            result = Lists.newArrayListWithCapacity(labels.size());
            for (Label label : labels) {
                result.add(transfer(label));
            }
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<LabelVO> searchLabel(String keyword, List<Integer> partitionIds, List<Integer> labelGroupIds, int labelType) {
//        List<LabelVO> result = Lists.newArrayListWithCapacity(0);
        Long startTime = System.currentTimeMillis();
        List<Label> labels = labelMapper.findByKeyword(keyword, partitionIds, labelGroupIds, labelType);

       // log.info("searchLabel cost:" + (System.currentTimeMillis() - startTime));

//        if (labels != null && labels.size() > 0) {
//            result = Lists.newArrayListWithCapacity(labels.size());

//            for (Label label : labels) {
//                result.add(transfer(labels));
//            }
//        }

        return transfer(labels);
    }
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<Label> searchLabels(String keyword, List<Integer> partitionIds, List<Integer> labelGroupIds, int labelType) {
//        List<LabelVO> result = Lists.newArrayListWithCapacity(0);
        Long startTime = System.currentTimeMillis();
        List<Label> labels = labelMapper.findByKeyword(keyword, partitionIds, labelGroupIds, labelType);

        //log.info("searchLabel cost:" + (System.currentTimeMillis() - startTime));

//        if (labels != null && labels.size() > 0) {
//            result = Lists.newArrayListWithCapacity(labels.size());

//            for (Label label : labels) {
//                result.add(transfer(labels));
//            }
//        }

        return labels;
    }

    @Override
    public List<LabelVO> getLabelByParentId(Integer parentId) {
        List<Label> list = labelMapper.findByParentId(parentId);
        return transferList(list);
    }

    private void flushCache(List<Integer> labelIds) {
        if (labelIds != null && labelIds.size() > 0) {
            for (Integer labelId : labelIds) {
                String redisKey = LabelUtils.genRedisKey(labelId);
                redisTemplate.delete(redisKey);
            }
        }
    }

    /**
     * 转换标签列表为VO列表
     *
     * @param labels 标签列表
     * @return 标签VO列表
     */
    private List<LabelVO> transferList(List<Label> labels) {
        List<LabelVO> result = Lists.newArrayListWithCapacity(0);

        if (CommonUtils.checkCollecitonNotEmpty(labels)) {
            result = Lists.newArrayListWithCapacity(labels.size());

            for (Label label : labels) {
                result.add(transfer(label));
            }
        }

        return result;
    }

    /**
     * 转换标签VO
     *
     * @param label 标签
     * @return LabelVO
     */
    private LabelVO transfer(Label label) {
        LabelVO labelVO = new LabelVO();
        CommonUtils.copyProperties(label, labelVO);
        
        List<LabelRelation> relationList = labelRelationMapper.findByLabelId(label.getLabelId());
        
        int userRelationNum = 0;
        int ingredientsRelationNum = 0;
        int marketingRelationNum = 0;
        
        for (LabelRelation entity : relationList) {
        	if(LabelRelationTypeEnum.USER.getId() == entity.getRelationType()) {
        		userRelationNum++;
        	}
        	
        	if(LabelRelationTypeEnum.INGREDIENTS.getId() == entity.getRelationType()) {
        		ingredientsRelationNum++;
        	}
        	
        	if(LabelRelationTypeEnum.CONTENT.getId() == entity.getRelationType()) {
        		marketingRelationNum++;
        	}
        }
        
//        log.info("relationList.size() {}, userRelationNum {}, ingredientsRelationNum {}, marketingRelationNum {}",
//        		relationList.size(), userRelationNum, ingredientsRelationNum, marketingRelationNum);
        
        labelVO.setUserRelationNum(userRelationNum);
        labelVO.setIngredientsRelationNum(ingredientsRelationNum);
        labelVO.setMarketingRelationNum(marketingRelationNum);
        
        if (userRelationNum > 0 && ingredientsRelationNum > 0 && marketingRelationNum > 0) {
        	labelVO.setIsUse(LabelIsUseEnum.USED.getId());
        } else {
        	labelVO.setIsUse(LabelIsUseEnum.NOT_USED.getId());
        }
        
        
        // 查询关联数量
        //labelVO.setUserRelationNum(labelRelationMapper.countLabel(label.getLabelId(), LabelRelationTypeEnum.USER.getId()));
        //labelVO.setIngredientsRelationNum(labelRelationMapper.countLabel(label.getLabelId(), LabelRelationTypeEnum.INGREDIENTS.getId()));
        //labelVO.setMarketingRelationNum(labelRelationMapper.countLabel(label.getLabelId(), LabelRelationTypeEnum.CONTENT.getId()));

        // 标签是否使用中
        //Integer count = labelRelationMapper.countLabel(label.getLabelId(), null);
       // labelVO.setIsUse(LabelIsUseEnum.getId(count));

        // 其他信息
        labelVO.setLabelPartitionName(LabelPartitionEnum.getName(labelVO.getLabelPartition()));
        labelVO.setLabelTypeName(LabelTypeEnum.getName(labelVO.getLabelType()));
        labelVO.setLabelStatusName(LabelStatusEnum.getName(labelVO.getLabelStatus()));
        labelVO.setIsUserShowName(LabelUserShowEnum.getName(labelVO.getIsUserShow()));

//        log.info("liuyang labelVO.getLabelGroupId()1 ");

        if (labelVO.getLabelGroupId() == null) {
            labelVO.setLabelGroupName("无");
        } else {
//            log.info("liuyang labelVO.getLabelGroupId()2 " + labelVO.getLabelGroupId() + " LabelGroupEnum.getName " + LabelGroupEnum.getName(labelVO.getLabelGroupId()));
        	labelVO.setLabelGroupName(LabelGroupEnum.getName(labelVO.getLabelGroupId()));
        }

        return labelVO;
    }

    /**
     * 转换标签VO
     *
     * @param label 标签
     * @return LabelVO
     */
    private LabelVO simpleTransfer(Label label) {
        LabelVO labelVO = new LabelVO();
        CommonUtils.copyProperties(label, labelVO);

        // 其他信息
        labelVO.setLabelPartitionName(LabelPartitionEnum.getName(labelVO.getLabelPartition()));
        labelVO.setLabelTypeName(LabelTypeEnum.getName(labelVO.getLabelType()));
        labelVO.setLabelStatusName(LabelStatusEnum.getName(labelVO.getLabelStatus()));
        labelVO.setIsUserShowName(LabelUserShowEnum.getName(labelVO.getIsUserShow()));

//        log.info("liuyang labelVO.getLabelGroupId()1 ");

        if (labelVO.getLabelGroupId() == null) {
            labelVO.setLabelGroupName("无");
        } else {
//            log.info("liuyang labelVO.getLabelGroupId()2 " + labelVO.getLabelGroupId() + " LabelGroupEnum.getName " + LabelGroupEnum.getName(labelVO.getLabelGroupId()));
            labelVO.setLabelGroupName(LabelGroupEnum.getName(labelVO.getLabelGroupId()));
        }

        return labelVO;
    }

	private List<LabelVO> transfer(List<Label> labelList) {
//		Long startTime = System.currentTimeMillis();

		List<LabelVO> list = new LinkedList<>();
		LabelVO labelVO = null;
		// CommonUtils.copyProperties(label, labelVO);

		List<Integer> labelIdList = new LinkedList<>();

		Map<Integer, Label> labelMap = new LinkedHashMap<>();

		for (Label label : labelList) {
			labelIdList.add(label.getLabelId());

			labelMap.put(label.getLabelId(), label);
		}

		List<LabelRelation> allRelationList = labelRelationMapper.findByLabelIds(labelIdList);

		Map<Integer, List<LabelRelation>> allRelationMap = new LinkedHashMap<>();

		Integer labelId = null;
		List<LabelRelation> tempRelationList = null;

		for (LabelRelation entity : allRelationList) {
			labelId = entity.getLabelId();

			if (allRelationMap.get(labelId) != null) {
				tempRelationList = allRelationMap.get(labelId);
				tempRelationList.add(entity);
			} else {
				tempRelationList = new LinkedList<>();
				tempRelationList.add(entity);
			}

			allRelationMap.put(labelId, tempRelationList);
		}

		Iterator<Integer> iter = allRelationMap.keySet().iterator();

		while (iter.hasNext()) {
			labelId = iter.next();

			tempRelationList = allRelationMap.get(labelId);

			Integer userRelationNum = 0;
			Integer ingredientsRelationNum = 0;
			Integer marketingRelationNum = 0;

			labelVO = new LabelVO();

			for (LabelRelation entity : tempRelationList) {
				if (LabelRelationTypeEnum.USER.getId() == entity.getRelationType()) {
					userRelationNum++;
				}

				if (LabelRelationTypeEnum.INGREDIENTS.getId() == entity.getRelationType()) {
					ingredientsRelationNum++;
				}

				if (LabelRelationTypeEnum.CONTENT.getId() == entity.getRelationType()) {
					marketingRelationNum++;
				}
			}

			CommonUtils.copyProperties(labelMap.get(labelId), labelVO);

			labelVO.setUserRelationNum(userRelationNum);
			labelVO.setIngredientsRelationNum(ingredientsRelationNum);
			labelVO.setMarketingRelationNum(marketingRelationNum);

			if (userRelationNum > 0 && ingredientsRelationNum > 0 && marketingRelationNum > 0) {
				labelVO.setIsUse(LabelIsUseEnum.USED.getId());
			} else {
				labelVO.setIsUse(LabelIsUseEnum.NOT_USED.getId());
			}

			labelVO.setLabelPartitionName(LabelPartitionEnum.getName(labelVO.getLabelPartition()));
			labelVO.setLabelTypeName(LabelTypeEnum.getName(labelVO.getLabelType()));
			labelVO.setLabelStatusName(LabelStatusEnum.getName(labelVO.getLabelStatus()));
			labelVO.setIsUserShowName(LabelUserShowEnum.getName(labelVO.getIsUserShow()));

			if (labelVO.getLabelGroupId() == null) {
				labelVO.setLabelGroupName("无");
			} else {
				labelVO.setLabelGroupName(LabelGroupEnum.getName(labelVO.getLabelGroupId()));
			}

			list.add(labelVO);
		}

//		log.info("searchLabel cost2:" + (System.currentTimeMillis() - startTime));

		// List<LabelRelation> relationList =
		// labelRelationMapper.findByLabelId(label.getLabelId());
		//
		// int userRelationNum = 0;
		// int ingredientsRelationNum = 0;
		// int marketingRelationNum = 0;
		//
		// for (LabelRelation entity : relationList) {
		// if(LabelRelationTypeEnum.USER.getId() == entity.getRelationType()) {
		// userRelationNum++;
		// }
		//
		// if(LabelRelationTypeEnum.INGREDIENTS.getId() == entity.getRelationType()) {
		// ingredientsRelationNum++;
		// }
		//
		// if(LabelRelationTypeEnum.CONTENT.getId() == entity.getRelationType()) {
		// marketingRelationNum++;
		// }
		// }

		// 查询关联数量
		// labelVO.setUserRelationNum(labelRelationMapper.countLabel(label.getLabelId(),
		// LabelRelationTypeEnum.USER.getId()));
		// labelVO.setIngredientsRelationNum(labelRelationMapper.countLabel(label.getLabelId(),
		// LabelRelationTypeEnum.INGREDIENTS.getId()));
		// labelVO.setMarketingRelationNum(labelRelationMapper.countLabel(label.getLabelId(),
		// LabelRelationTypeEnum.CONTENT.getId()));

		// 标签是否使用中
		// Integer count = labelRelationMapper.countLabel(label.getLabelId(), null);
		// labelVO.setIsUse(LabelIsUseEnum.getId(count));

		// 其他信息
		// labelVO.setLabelPartitionName(LabelPartitionEnum.getName(labelVO.getLabelPartition()));
		// labelVO.setLabelTypeName(LabelTypeEnum.getName(labelVO.getLabelType()));
		// labelVO.setLabelStatusName(LabelStatusEnum.getName(labelVO.getLabelStatus()));
		// labelVO.setIsUserShowName(LabelUserShowEnum.getName(labelVO.getIsUserShow()));
		// if (labelVO.getLabelGroupId() == null) {
		// labelVO.setLabelGroupName("无");
		// } else {
		//// LabelGroupVO vo =
		// labelGroupService.getLabelGroupById(labelVO.getLabelGroupId());
		//// if (vo != null) {
		//// labelVO.setLabelGroupName(vo.getLabelGroupName());
		//// }
		// }

		// return labelVO;
		return list;
	}

    /**
     * 清空饮食推荐内存级别的缓存数据
     */
    private void flushDietServiceCache() {
        ZkUtils.updatePersistentPath(ZKServicePathConstants.ZK_CONFIG_ROOT + ZKServicePathConstants.DIET_LABEL_CACHE_SERVICE_PATH, "1");
    }
}
