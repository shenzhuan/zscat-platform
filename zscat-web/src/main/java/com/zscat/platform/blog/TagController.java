package com.zscat.platform.blog;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zscat.blog.entity.ArticleCustom;
import com.zscat.blog.entity.Pager;
import com.zscat.blog.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 展示页面标签controller
 * @author EumJI
 * @package com.eumji.zblog.controller.admin
 * @name TagController
 * @date 2017/4/13
 * @time 18:54
 */
@Controller
@RequestMapping("/blog/tags")
public class TagController {

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TagService tagService;

    /**
     * 通过tag获取文章列表
     * @param pager 分页信息
     * @param tagId 标签id
     * @param model 数据视图
     * @return
     */
   @RequestMapping("/load/{tagId}")
    public String loadArticleByTag(Pager pager, @PathVariable Integer tagId, Model model){
       List<ArticleCustom> articleList = tagService.loadArticleByTag(pager,tagId);
       if (!articleList.isEmpty()){
           pager.setTotalCount(1);
           pager.setPageNum(1);
           model.addAttribute("articleList",articleList);
           model.addAttribute("pager",pager);
           //2017-05-07修复获取tag名称错误的问题,不应该从articlelist中取,因为每篇文章可能有多个tag
           model.addAttribute("tagName",tagService.getTagById(tagId).getTagName());
       }

       return "blog/part/tagSummary";
   }

}

