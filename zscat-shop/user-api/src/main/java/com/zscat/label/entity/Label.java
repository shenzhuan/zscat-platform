package com.zscat.label.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Label
 *
 * @author liuruichao
 * Created on 2018/10/11 16:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Label extends BaseEntity {
    private static final long serialVersionUID = 5464788195925556200L;


    /** 标签ID */
    private Integer labelId;

    /** 标签大类 用户标签(1)  内容标签(2)  兼容标签(3) */
    private Integer labelPartition;

    /** 标签分组 */
    private Integer labelGroupId;

    /** 标签类型 */
    private Integer labelType;

    /** 标签名称 */
    private String labelName;

    /** 标签状态 */
    private Integer labelStatus;

    /** 用户端是否展示 */
    private Integer isUserShow;

    /** 备注。不超过100个字符的文本。 */
    private String remark;

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

    public Integer getLabelType() {
        return labelType;
    }

    public void setLabelType(Integer labelType) {
        this.labelType = labelType;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(Integer labelStatus) {
        this.labelStatus = labelStatus;
    }

    public Integer getIsUserShow() {
        return isUserShow;
    }

    public void setIsUserShow(Integer isUserShow) {
        this.isUserShow = isUserShow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /** 标签父ID */
    private Integer parentId;

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

}