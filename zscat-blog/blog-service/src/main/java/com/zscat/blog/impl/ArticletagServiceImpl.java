package com.zscat.blog.impl;

import com.zscat.blog.service.ArticletagService;
import lombok.extern.log4j.Log4j2;

/**
* Created by GeneratorFx on 2017-04-11.
*/
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
public class ArticletagServiceImpl implements ArticletagService {


}
