package com.zscat.label.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * LabelVO
 *
 * @author zscat
 * Created on 2018/11/2 17:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LabelVO extends Label {
    private static final long serialVersionUID = 944454976675246159L;

    /** 开始时间 */
    private String startTime, createTimeMin;

    /** 结束时间 */
    private String endTime, createTimeMax;

    /** 用户关联数量 */
    private Integer userRelationNum;

    /** 食材关联数量 */
    private Integer ingredientsRelationNum;

    /** 营销软文关联数量 */
    private Integer marketingRelationNum;

    /** 该标签是否使用中 0:全部 1:未使用 2:使用中  */
    private Integer isUse;

    /** 当前第几页*/
    private Integer page;

    /** 每页显示记录数 */
    private Integer pageSize;

    /** 偏移量 */
    private Integer offset;

    /** 关键字 */
    private String searchKeyword;

    private String labelPartitionName;

    private String labelGroupName;

    private String labelTypeName;

    private String labelStatusName;

    private String isUserShowName;

    private String labelPartitions;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCreateTimeMin() {
        return createTimeMin;
    }

    public void setCreateTimeMin(String createTimeMin) {
        this.createTimeMin = createTimeMin;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreateTimeMax() {
        return createTimeMax;
    }

    public void setCreateTimeMax(String createTimeMax) {
        this.createTimeMax = createTimeMax;
    }

    public Integer getUserRelationNum() {
        return userRelationNum;
    }

    public void setUserRelationNum(Integer userRelationNum) {
        this.userRelationNum = userRelationNum;
    }

    public Integer getIngredientsRelationNum() {
        return ingredientsRelationNum;
    }

    public void setIngredientsRelationNum(Integer ingredientsRelationNum) {
        this.ingredientsRelationNum = ingredientsRelationNum;
    }

    public Integer getMarketingRelationNum() {
        return marketingRelationNum;
    }

    public void setMarketingRelationNum(Integer marketingRelationNum) {
        this.marketingRelationNum = marketingRelationNum;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getLabelPartitionName() {
        return labelPartitionName;
    }

    public void setLabelPartitionName(String labelPartitionName) {
        this.labelPartitionName = labelPartitionName;
    }

    public String getLabelGroupName() {
        return labelGroupName;
    }

    public void setLabelGroupName(String labelGroupName) {
        this.labelGroupName = labelGroupName;
    }

    public String getLabelTypeName() {
        return labelTypeName;
    }

    public void setLabelTypeName(String labelTypeName) {
        this.labelTypeName = labelTypeName;
    }

    public String getLabelStatusName() {
        return labelStatusName;
    }

    public void setLabelStatusName(String labelStatusName) {
        this.labelStatusName = labelStatusName;
    }

    public String getIsUserShowName() {
        return isUserShowName;
    }

    public void setIsUserShowName(String isUserShowName) {
        this.isUserShowName = isUserShowName;
    }

    public String getLabelPartitions() {
        return labelPartitions;
    }

    public void setLabelPartitions(String labelPartitions) {
        this.labelPartitions = labelPartitions;
    }

    /**
     * 分页查询计算偏移量
     * @return offset
     */
    public Integer getOffset() {
        if (page != null && pageSize != null) {
            return (page - 1) * pageSize;
        }

        return -1;
    }
}