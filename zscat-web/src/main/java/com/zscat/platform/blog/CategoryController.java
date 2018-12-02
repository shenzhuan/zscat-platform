package com.zscat.platform.blog;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zscat.blog.entity.ArticleCustom;
import com.zscat.blog.entity.Pager;
import com.zscat.blog.entity.Partner;
import com.zscat.blog.service.CategoryService;
import com.zscat.blog.service.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 展示的分类controller
 * FILE: com.eumji.zblog.controller.ArchiveController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: ZSCAT
 * DATE: 2017/5/8
 * TIME: 15:15
 */
@Controller
@RequestMapping("/blog/categories")
public class CategoryController {

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    CategoryService categoryService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    PartnerService partnerService;

    /**
     * 获取某个标签的分页文章
     * @param model
     * @param pager
     * @param categoryId
     * @return
     */
    @RequestMapping("/load/{categoryId}")
    public String loadArticleByCategory(Model model, Pager pager, @PathVariable Integer categoryId){
        List<ArticleCustom> articleList = categoryService.loadArticleByCategory(pager,categoryId);
        if (!articleList.isEmpty()){
            pager.setTotalCount(1);
            pager.setPageNum(1);
            model.addAttribute("articleList",articleList);
            model.addAttribute("pager",pager);
            model.addAttribute("categoryName",articleList.get(0).getCategoryName());
        }
        return "blog/part/categorySummary";
    }

    /**
     * 跳转到分类的页面 暂时停用
     * @param model
     * @param categoryId
     * @return
     */
    @Deprecated
    @RequestMapping("/details/{categoryId}")
    public String categoryPage(Model model, @PathVariable Integer categoryId){
        List<Partner> partnerList = partnerService.findAll();
        model.addAttribute("partnerList",partnerList);
        model.addAttribute("categoryId",categoryId);
        return "category";
    }



}
