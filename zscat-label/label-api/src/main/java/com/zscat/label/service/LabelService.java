package com.zscat.label.service;


import com.zscat.label.entity.Label;
import com.zscat.label.entity.LabelVO;

import java.util.List;

/**
 * LabelService
 *
 * @author zscat
 * Created on 2018/10/11 18:02
 */
public interface LabelService {
    /**
     * 添加标签
     * @param labelVO labelVO
     * @return 成功返回实体，失败返回null
     */
    LabelVO addLabel(LabelVO labelVO);

    /**
     * 更新标签
     * @param label 标签实体
     * 必传参数：
     *   1. isUserShow
     *   2. labelStatus
     *   3. labelName
     *   4. remark
     *   5. labelId
     * @return 更新后的标签
     */
    LabelVO updateLabel(Label label);

    /**
     * 根据筛选条件获取标签列表
     * @param labelVO 筛选条件
     * 筛选条件：
     *   1. labelPartition 标签大类ID   枚举: LabelPartitionEnum
     *   2. labelGroupId   标签分组ID   动态获取
     *   3. labelType      标签类型     枚举: LabelTypeEnum
     *   4. isUserShow     标签展示类型  枚举: LabelUserShowEnum
     *   5. labelStatus    标签状态     枚举: LabelStatusEnum
     *   6. startTime      创建开始时间
     *   7. endTime        创建结束时间
     * @return 标签列表
     */
    List<LabelVO> list(LabelVO labelVO);

    /**
     * 根据筛选条件获取标签列表
     * @param labelVO 筛选条件
     * 筛选条件：
     *   1. labelPartition 标签大类ID   枚举: LabelPartitionEnum
     *   2. labelGroupId   标签分组ID   动态获取
     *   3. labelType      标签类型     枚举: LabelTypeEnum
     *   4. isUserShow     标签展示类型  枚举: LabelUserShowEnum
     *   5. labelStatus    标签状态     枚举: LabelStatusEnum
     *   6. startTime      创建开始时间
     *   7. endTime        创建结束时间
     * @return 标签列表总数
     */
    long listCount(LabelVO labelVO);

    /**
     * 根据标签分组id获取标签
     * @param labelGroupId 标签分组id
     * @return 标签列表
     */
    List<LabelVO> listByGroup(Integer labelGroupId);

    /**
     * 根据ID获取标签
     * @param labelId 标签ID
     * @return 标签
     */
    LabelVO getLabelById(Integer labelId);

    /**
     * 根据标签名称获取标签
     * @param labelName 标签名称
     * @return 标签
     */
    LabelVO getCurrentSeasonLabel(String labelName);

    /**
     * 根据标签ID列表删除标签
     * @param labelIds 标签ID列表
     * @return true: 成功 false: 失败
     */
    boolean delLabel(List<Integer> labelIds);

    /**
     * 批量激活标签
     * @param labelIds 标签ID列表
     * @return true: 成功 false: 失败
     */
    boolean enableLabel(List<Integer> labelIds);

    /**
     * 批量停用标签
     * @param labelIds 标签ID列表
     * @return true: 成功 false: 失败
     */
    boolean disableLabel(List<Integer> labelIds);

    /**
     * 根据关键字、大类ID列表、分组ID列表查询标签
     * @param keyword 关键字
     * @param partitionIds 大类ID列表，为空则不过滤。
     * @param labelGroupIds 分组ID列表，为空则不过滤。
     * @return 标签列表
     */
    List<LabelVO> searchLabel(String keyword, List<Integer> partitionIds, List<Integer> labelGroupIds);

    /**
     * 根据关键字、大类ID列表、分组ID列表查询标签
     * @param keyword
     * @param partitionIds
     * @param labelGroupIds
     * @param labelType
     * @return
     */
    List<LabelVO> searchLabel(String keyword, List<Integer> partitionIds, List<Integer> labelGroupIds, int labelType);


    List<Label> searchLabels(String keyword, List<Integer> partitionIds, List<Integer> labelGroupIds, int labelType);
    /**
     * 根据标签父ID查询标签列表
     * @param parentId 标签父ID
     * @return 标签列表
     */
    List<LabelVO> getLabelByParentId(Integer parentId);
}
