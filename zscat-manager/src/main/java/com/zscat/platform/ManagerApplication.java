package com.zscat.platform;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DubboConsumerApplication
 * 消费者启动类
 *
 * @author xiaoze
 * @date 2018/6/7
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zscat.platform.*.dao")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan("com.zscat")
@EnableDubbo
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}
