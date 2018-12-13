package com.zscat.label;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DubboProviderApplication
 * 服务提供启动类
 * @author xiaoze
 * @date 2018/6/7
 */
@SpringBootApplication
@Log4j2
@MapperScan(basePackages = "com.zscat.label.dao")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan("com.zscat")
@EnableDubbo
public class UserProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UserProviderApplication.class)
                .web(false) // 非 Web 应用
                .run(args);
    }
}
