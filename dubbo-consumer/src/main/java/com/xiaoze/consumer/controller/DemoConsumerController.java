package com.xiaoze.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zscat.label.entity.LabelVO;
import com.zscat.label.service.LabelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoConsumerController
 * 消费者控制层
 * @author xiaoze
 * @date 2018/6/7
 */
@RestController
public class DemoConsumerController {

    @Reference(
            version = "${label.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private LabelService labelService;

    @GetMapping("hello/{name}")
    public LabelVO sayHello(@PathVariable String name){
        System.out.println("na:"+name);
        return labelService.getLabelById(1);
    }


}
