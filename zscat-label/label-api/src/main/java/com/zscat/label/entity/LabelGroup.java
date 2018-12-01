package com.zscat.label.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * LabelGroup
 *
 * @author liuruichao
 * Created on 2018/10/11 18:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LabelGroup extends BaseEntity {
    private static final long serialVersionUID = -7299360897748935078L;

    private Integer labelGroupId;

    private String labelGroupName;
}
