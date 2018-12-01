package com.zscat.label.dao;


import com.zscat.label.entity.LabelGroup;

import java.util.List;

/**
 * LabelGroupMapper
 *
 * @author zscat
 * Created on 2018/10/12 18:58
 */
public interface LabelGroupMapper {
    /**
     * 查询所有标签分组
     * @return 标签分组列表
     */
    List<LabelGroup> findAll();

    /**
     * 根据ID查询标签分组
     * @param id
     * @return
     */
    LabelGroup findById(Integer id);
}