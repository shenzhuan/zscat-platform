package com.zscat.label.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author liuruichao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LabelRelation extends BaseEntity {
    private static final long serialVersionUID = 634744321819224246L;



    /** 标签关联ID */
    private Integer labelRelationId;

    /** 标签ID */
    private Integer labelId;

    /** 标签名称 */
    private String labelName;

    /** 标签大类 */
    private Integer labelPartition;

    /** 标签分组ID */
    private Integer labelGroupId;

    /** 关联ID */
    private Integer relationId;

    /** 关联类型 */
    private Integer relationType;

    public Integer getLabelRelationId() {
        return labelRelationId;
    }

    public void setLabelRelationId(Integer labelRelationId) {
        this.labelRelationId = labelRelationId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getLabelPartition() {
        return labelPartition;
    }

    public void setLabelPartition(Integer labelPartition) {
        this.labelPartition = labelPartition;
    }

    public Integer getLabelGroupId() {
        return labelGroupId;
    }

    public void setLabelGroupId(Integer labelGroupId) {
        this.labelGroupId = labelGroupId;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }
}