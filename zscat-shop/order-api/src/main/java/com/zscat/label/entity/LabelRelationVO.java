package com.zscat.label.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * LabelRelationVO
 *
 * @author liuruichao
 * Created on 2018/11/6 12:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LabelRelationVO extends LabelRelation {
    private static final long serialVersionUID = -5207330984232045843L;

    /** 关联ID列表 */
    private List<Integer> relationIds;

    /** 标签ID列表 */
    private List<Integer> labelIds;
}
