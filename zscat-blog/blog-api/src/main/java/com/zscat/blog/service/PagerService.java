package com.zscat.blog.service;

import com.zscat.blog.entity.Pager;

/**
 * @author Do
 * @package com.zscat.blog.service
 * @name PagerService
 * @date 2017/4/11
 * @time 21:46
 */
public interface PagerService {
    /**
     * 初始化分页信息
     * @return
     * @param pager
     */
    void initPage(Pager pager);

    /**
     * 初始化某个category的分页信息
     * @param pager
     * @param categoryId
     */
    void loadCategoryPager(Pager pager, Integer categoryId);

    /**
     * 初始化某个tag的分页信息
     * @param pager
     * @param tagId
     */
    void loadTagPager(Pager pager, Integer tagId);
}
