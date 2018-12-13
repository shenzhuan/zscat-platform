package com.zscat.label;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.container.Main;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DubboProviderApplication
 * 服务提供启动类
 * * @author zscat
 * @date 2018/6/7
 */
@SpringBootApplication
@Log4j2
@MapperScan(basePackages = "com.zscat.label.dao")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan("com.zscat")
@EnableDubbo
public class LabelProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabelProviderApplication.class, args);
        Main.main(args);
    }
}
