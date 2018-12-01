package com.zscat.label.service;


import com.zscat.label.entity.LabelRelation;
import com.zscat.label.entity.LabelRelationVO;
import com.zscat.label.entity.LabelVO;

import java.util.List;

/**
 * 标签关联关系Service
 *
 * @author zscat
 * Created on 2018/11/6 10:39
 */
public interface LabelRelationService {
    /**
     * 根据筛选标签ID列表、关联类型计算出关联ID列表中符合label条件的数量
     * @param vo labelVO
     * 必传参数：
     *   1. relationIds 关联ID列表
     *   2. labelIds 筛选标签ID列表
     *   3. relationType 关联类型  枚举: LabelRelationTypeEnum
     * @return 关联ID列表中符合label条件的数量
     */
    Integer countByLabelIds(LabelRelationVO vo);

    /**
     * 过滤出关联ID列表中含有标签ID列表的ID列表
     * @param vo labelVO
     * 必传参数：
     *   1. relationIds 关联ID列表
     *   2. labelIds 筛选标签ID列表
     *   3. relationType 关联类型  枚举: LabelRelationTypeEnum
     * @return 含有标签ID列表的ID列表
     */
    List<Integer> containsLabelIds(LabelRelationVO vo);

    /**
     * 添加标签关系
     * @param labelRelation 标签关系实体
     * @return true: 成功 false: 失败
     */
    boolean addLabelRelation(LabelRelation labelRelation);

    /**
     * 添加关联ID和标签ID关系。异步执行。
     * @param vo labelVO
     * 必传参数：
     *   1. relationIds 关联ID列表
     *   2. labelId 标签ID
     *   3. relationType 关联类型  枚举: LabelRelationTypeEnum
     * @return true: 成功 false: 失败
     */
    boolean addLabelRelation(LabelRelationVO vo);

    /**
     * 删除标签关系
     * @param labelRelation 标签关系实体
     * @return true: 成功 false: 失败
     */
    boolean delLabelRelation(LabelRelation labelRelation);

    /**
     *
     * @param relationType
     * @param relationId
     * @return
     */
    boolean delLabelRelation(Integer relationType, Integer relationId);

    /**
     * 删除关联ID和标签ID关系。异步执行。
     * @param vo labelVO
     * 必传参数：
     *   1. relationIds 关联ID列表
     *   2. labelId 标签ID
     *   3. relationType 关联类型  枚举: LabelRelationTypeEnum
     * @return true: 成功 false: 失败
     */
    boolean delLabelRelation(LabelRelationVO vo);

    /**
     * 根据关联ID和关联类型查询关联的标签
     * @param vo labelVO
     * 必传参数：
     *   1. relationId
     *   2. relationType
     * @return 关联的标签列表
     */
    List<LabelVO> getLabelByRelationId(LabelRelationVO vo);

    /**
     * 根据关联ID和类型查询标签ID
     * @param labelRelation labelRelation
     * 必传参数：
     *   1. relationId
     *   2. relationType
     * @return 标签列表ID
     */
    List<Integer> getLabelByRelationId(LabelRelation labelRelation);

    /**
     * 根据关联类型获取标签关系
     * @param relationType 关系类型
     * @return 标签关系列表
     */
    List<LabelRelationVO> getByRelationType(Integer relationType);

    /**
     * 根据关联类型和标签ID列表查询关系
     * @param vo vo
     * 必传参数：
     *   1. relationType
     *   2. labelIds
     * @return 关系VO列表
     */
    List<LabelRelationVO> getLabeRelationlVOByRelationTypeAndLabelIds(LabelRelationVO vo);

    /**
     * 根据关联类型和标签ID列表查询关系
     * @param vo vo
     * 必传参数：
     *   1. relationType
     *   2. labelIds
     * @return 关联ID列表
     */
    List<Integer> getRelationIdByRelationTypeAndLabelIds(LabelRelationVO vo);

    /**
     * 查询减脂营用户等级标签
     * @param userId 用户ID
     * @return 关系实体，没有返回null
     */
    LabelRelationVO getFitCampLabels(Integer userId);

    /**
     * 查询辣妈营用户等级标签
     * @param userId 用户ID
     * @return 关系实体，没有返回null
     */
    LabelRelationVO getHotCampLabels(Integer userId);

    /**
     * 查询辣妈营用户等级标签
     * @param userId 用户ID
     * @return 关系实体，没有返回null
     */
    LabelRelationVO getGroupLabels(Integer userId, List<Integer> labelIds, Integer relationType) ;

    /**
     * 更新关联关系
     * @param vo
     * 必传参数：
     *   1. labelRelationId 主键
     *   2. labelId         标签ID
     * @return 更新后的实体类
     */
    LabelRelationVO updateLabelRelation(LabelRelationVO vo);

    /**
     * 根据条件查询关系列表
     * @param relationId
     * @return 关联关系列表
     */
    LabelRelation findLabelRelation(Integer relationId, Integer relationType, Integer labelId);
}