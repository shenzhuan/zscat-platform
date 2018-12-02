package com.zscat.blog.impl;


import com.zscat.blog.dao.ArticleMapper;
import com.zscat.blog.dao.PagerMapper;
import com.zscat.blog.entity.Pager;
import com.zscat.blog.service.PagerService;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @author: zscat
 * @date: 2018/7/10
 * @Description: TODO
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "${blog.service.version}",
        application = "${dubbo.application.id}",
        registry = "${dubbo.registry.id}"
)
@Log4j2
public class PagerServiceImpl implements PagerService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private PagerMapper pagerMapper;
    @Override
    public void initPage(Pager pager) {
        int count = articleMapper.getArticleCount();
        pager.setTotalCount(count);
    }

    @Override
    public void loadCategoryPager(Pager pager,Integer categoryId) {
        int count = pagerMapper.loadCategoryPager(categoryId);
        pager.setTotalCount(count);
    }

    @Override
    public void loadTagPager(Pager pager, Integer tagId) {
        int count = pagerMapper.loadTagPager(tagId);
        pager.setTotalCount(count);
    }
}
