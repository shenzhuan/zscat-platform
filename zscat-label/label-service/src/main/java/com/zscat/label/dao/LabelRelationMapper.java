package com.zscat.label.dao;

import com.zscat.label.entity.LabelRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LabelRelationMapper
 *
 * @author liuruichao
 * Created on 2018/11/06 18:58
 */
public interface LabelRelationMapper {
    /**
     * 添加一条标签关联关系记录
     * @param record 记录
     * @return DB update rows
     */
    int insert(LabelRelation record);

    /**
     * 批量添加
     * @param relations 记录列表
     * @return DB update rows
     */
    int batchInsert(List<LabelRelation> relations);

    /**
     * 根据ID查询
     * @param labelRelationId ID
     * @return 关联关系
     */
    LabelRelation selectByPrimaryKey(Integer labelRelationId);

    /**
     * 根据ID进行更新
     * @param record
     * @return DB update rows
     */
    int updateByPrimaryKey(LabelRelation record);

    /**
     * 根据关联ID和关联类型查询关系列表
     * @param relationId 关联ID
     * @param relationType 关联类型
     * @return 关系列表
     */
    List<LabelRelation> findByRelationId(@Param("relationId") Integer relationId, @Param("relationType") Integer relationType);

    /**
     * 批量删除
     * @param relationIds 关联ID列表
     * @param relationType 关联类型
     * @param labelId 标签ID
     * @return db update rows
     */
    int batchDelete(@Param("relationIds") List<Integer> relationIds, @Param("relationType") Integer relationType, @Param("labelId") Integer labelId);

    /**
     * 查询标签关联数量
     * @param labelId 标签ID
     * @param relationType 关联类型
     * @return 关联数量
     */
    Integer countLabel(@Param("labelId") Integer labelId, @Param("relationType") Integer relationType);

    /**
     * 查询标签和关联ID数量
     * @param relationId 关联ID
     * @param labelId 标签ID
     * @param relationType 关联类型
     * @return 记录数量
     */
    Integer countLabelRelation(@Param("relationId") Integer relationId, @Param("labelId") Integer labelId, @Param("relationType") Integer relationType);

    /**
     * 根据关联类型和标签ID列表查询关联关系
     * @param relationType 关联类型
     * @param labelIds 标签ID列表(可为null)
     * @return 关联关系列表
     */
    List<LabelRelation> findByRelationTypeAndLabelIds(@Param("relationType") Integer relationType, @Param("labelIds") List<Integer> labelIds);

    /**
     * 根据条件查询关系列表
     * @param relationId
     * @return 关联关系列表
     */
    LabelRelation findEntity(@Param("relationId") Integer relationId, @Param("relationType") Integer relationType, @Param("labelIds") List<Integer> labelIds);

    /**
     * 根据条件查询关系列表
     * @param relationId
     * @return 关联关系列表
     */
    LabelRelation findLabelRelation(@Param("relationId") Integer relationId, @Param("relationType") Integer relationType, @Param("labelId") Integer labelId);

    List<LabelRelation> findByLabelId(@Param("labelId") Integer labelId);

    List<LabelRelation> findByLabelIds(@Param("labelIds") List<Integer> labelIds);

    /**
     *
     * @return
     */
    List<LabelRelation>  findAllLabelRelation();
}