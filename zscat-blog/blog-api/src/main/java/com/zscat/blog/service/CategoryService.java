package com.zscat.blog.service;


import com.zscat.blog.entity.ArticleCustom;
import com.zscat.blog.entity.Category;
import com.zscat.blog.entity.CategoryCustom;
import com.zscat.blog.entity.Pager;

import java.util.List;

/**
* Created by GeneratorFx on 2017-04-11.
*/
public interface CategoryService {



    List<ArticleCustom> loadArticleByCategory(Pager pager, Integer categoryId);

    /**
     * 初始化分类信息
     * @return
     */
    List<CategoryCustom> initCategoryList();

    Category getCategoryById(Integer id);

    List<Category> loadCategory(Pager pager, String categoryName);

    boolean checkExist(Category category);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void initPage(Pager pager);

    List<Category> getCategoryList();

    void ArticleCatePage(Pager pager, int categoryId);

    List<ArticleCustom> loadArticleByArchive(String createTime, Pager pager);

    int getArticleCountByCategoryId(Integer categoryId);

    boolean deleteCategoryById(Integer categoryId);
}
