package com.zscat.label.impl;

import com.google.common.collect.Lists;
import com.zscat.label.dao.LabelGroupMapper;
import com.zscat.label.entity.LabelGroup;
import com.zscat.label.entity.LabelGroupVO;
import com.zscat.label.service.LabelGroupService;
import com.zscat.label.utils.CommonUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
public class LabelGroupServiceImpl implements LabelGroupService {
    @Resource
    private LabelGroupMapper labelGroupMapper;

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<LabelGroupVO> listAll() {
        List<LabelGroup> list = labelGroupMapper.findAll();
        List<LabelGroupVO> result = Lists.newArrayListWithCapacity(list.size());

        for (LabelGroup labelGroup : list) {
            LabelGroupVO vo = new LabelGroupVO();
            CommonUtils.copyProperties(labelGroup, vo);
            result.add(vo);
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public LabelGroupVO getLabelGroupById(Integer labelGroupId) {
        LabelGroup labelGroup = labelGroupMapper.findById(labelGroupId);

        if (labelGroup != null) {
            LabelGroupVO vo = new LabelGroupVO();
            CommonUtils.copyProperties(labelGroup, vo);
            return vo;
        }

        return null;
    }
}
