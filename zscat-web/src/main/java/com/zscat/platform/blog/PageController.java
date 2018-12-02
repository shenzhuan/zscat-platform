package com.zscat.platform.blog;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zscat.blog.entity.ArticleCustom;
import com.zscat.blog.entity.CategoryCustom;
import com.zscat.blog.entity.Partner;
import com.zscat.blog.entity.Tag;
import com.zscat.blog.service.BlogArticleService;
import com.zscat.blog.service.CategoryService;
import com.zscat.blog.service.PartnerService;
import com.zscat.blog.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 首页入口controller
 * FILE: com.eumji.zblog.controller.IndexController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: ZSCAT
 * DATE: 2017/4/8
 * TIME: 15:19
 */
@Controller
@RequestMapping("/blog")
public class  PageController {

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private PartnerService partnerService;  //友情链接的service

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private BlogArticleService articleService; //分钟信息的service

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private CategoryService categoryService;  //分类的service

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TagService tagService;  //标签的service



    /**
     * 首页
     * 初始化信息
     * 1.标签，分类，文章数量
     * 2.友情链接
     * 3.分类列表 -> 用于文章分类显示
     * 4.时间归档列表
     * @param model
     * @return
     */

    @RequestMapping("/index")
    public String home(Model model){
        List<Partner> partnerList;
        partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();

        int articleCount = articleService.getArticleCount();
        List<Map> archiveList = articleService.articleArchiveList();
        int tagCount = tagService.getTagCount();
        List<Tag> tagList =tagService.getTagList();
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("tagList",tagList);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        model.addAttribute("archiveList",archiveList);

        return "blogindex";
    }

    /**
     * 分类排序 暂时停用
     * @return
     */
    @RequestMapping("/archives")
    @Deprecated
    public String archivesPage(){
        return "blog/archives";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    /**跳转到友链展示页面
     * @return
     */
    @RequestMapping("/partner/list")
    public String partnerPage() {
        return "admin/partner/partnerList";
    }


    /**
     * 关于我跳转
     * @param model
     * @return
     */

    @RequestMapping("/about/me")
    public String aboutMe(Model model){
        List<Partner> partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();
        int articleCount = articleService.getArticleCount();
        int tagCount = tagService.getTagCount();
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        return "blog/aboutMe";
    }

    @RequestMapping("/popular")
    public String popularArticle(Model model){

        List<Partner> partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();
        int articleCount = articleService.getArticleCount();
        List<ArticleCustom> articleList = articleService.popularArticle();
        int tagCount = tagService.getTagCount();
        List<Tag> tagList =tagService.getTagList();
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("tagList",tagList);
        model.addAttribute("articleList",articleList);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);

        return "blog/popular";
    }

    @RequestMapping("/thymeleaf")
    public String thymeleafPage(){
        return "blog/thymeleaf";
    }
}
