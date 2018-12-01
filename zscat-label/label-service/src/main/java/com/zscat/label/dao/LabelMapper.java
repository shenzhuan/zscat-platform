package com.zscat.label.dao;

import com.zscat.label.entity.Label;
import com.zscat.label.entity.LabelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LabelMapper
 *
 * @author zscat
 * Created on 2018/10/12 18:58
 */
public interface LabelMapper {
    /**
     * 保存标签
     * @param label 标签实体
     * @return DB update rows
     */
    int save(Label label);

    /**
     * 根据条件分页查询标签列表
     * @param vo vo
     * @return 标签列表
     */
    List<Label> listByPage(LabelVO vo);

    /**
     * 根据条件查询标签列表总数
     * @param vo vo
     * @return 标签列表总数
     */
    Long countByPage(LabelVO vo);

    /**
     * 根据标签分组ID查询标签列表
     * @param labelGroupId 标签分组ID
     * @return 标签列表
     */
    List<Label> findByLabelGroupId(Integer labelGroupId);

    /**
     *  根据ID查询标签
     * @param labelId 标签ID
     * @return 标签
     */
    Label findById(Integer labelId);

    /**
     * 查询所有标签
     * @return 标签列表
     */
    List<Label> findAll();

    /**
     * 获取应季食材标签
     * @param labelName 标签名称
     * @return 标签列表
     */
    List<Label> getCurrentSeasonLabel(@Param("labelName") String labelName);

    /**
     * 批量删除标签
     * @param labelIds 标签ID列表
     * @return DB update rows
     */
    int batchDelete(@Param("labelIds") List<Integer> labelIds);

    int delete(@Param("labelId") Integer labelId);

    /**
     * 批量更新标签状态
     * @param labelIds 标签ID列表
     * @param status   标签状态
     * @return DB update rows
     */
    int updateStatus(@Param("labelIds") List<Integer> labelIds, @Param("status") Integer status);

    /**
     * 查询关键字
     * @param keyword 关键字
     * @param partitionIds 标签大类列表
     * @param labelGroupIds 标签分组列表
     * @return 标签列表
     */
    List<Label> findByKeyword(@Param("keyword") String keyword,
                              @Param("partitionIds") List<Integer> partitionIds,
                              @Param("labelGroupIds") List<Integer> labelGroupIds, @Param("labelType") int labelType);

    /**
     * 更新标签
     * @param label 标签实体
     * @return db update rows
     */
    int update(Label label);

    List<Label> findByParentId(@Param("parentId") Integer parentId);


}