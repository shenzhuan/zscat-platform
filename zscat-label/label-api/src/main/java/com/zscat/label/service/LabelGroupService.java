package com.zscat.label.service;


import com.zscat.label.entity.LabelGroupVO;

import java.util.List;

/**
 * LabelGroupService
 *
 * @author liuruichao
 * Created on 2018/10/12 19:56
 */
public interface LabelGroupService {
    /**
     * 获取所有标签分组
     * @return 标签分组列表
     */
    List<LabelGroupVO> listAll();

    /**
     * 根据ID获取标签分组
     * @param labelGroupId 标签分组ID
     * @return 标签分组
     */
    LabelGroupVO getLabelGroupById(Integer labelGroupId);
}
