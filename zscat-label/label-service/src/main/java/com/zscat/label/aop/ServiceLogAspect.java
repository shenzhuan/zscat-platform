package com.zscat.label.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ServiceLogAspect
 *
 * @author liuruichao
 * Created on 2018/11/12 22:12
 */
@Aspect
@Component
@Log4j2
public class ServiceLogAspect {
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(public * com.zscat.*.impl.*.*(..))")
    public void serviceLog() {
        log.info("init ServiceLogAspetct success!");
    }

    @Before("serviceLog()")
    public void before(JoinPoint joinPoint) {
        threadLocal.set(System.currentTimeMillis());
        Signature signature = joinPoint.getSignature();
        log.info("class: {}, method: {}, params:{}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                getParamsStr(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "data", pointcut = "serviceLog()")
    public void after(Object data) {
        Long startTime = threadLocal.get();
        if (data != null && startTime != null) {
            /*log.info("return data: {}, cost: {} ms",
                    JSON.toJSONString(data),
                    (System.currentTimeMillis() - threadLocal.get()));*/

            log.info("return cost: {} ms",
                    (System.currentTimeMillis() - threadLocal.get()));
        }
        threadLocal.remove();
    }

    private String getParamsStr(Object[] objects) {
        StringBuilder sbu = new StringBuilder();

        if (objects != null && objects.length > 0) {
            int i = 1;
            for (Object obj : objects) {
                sbu.append(i).append(". ");

                if (obj != null) {
                    sbu.append(JSON.toJSONString(obj));
                }

                if (obj == null) {
                    sbu.append("null");
                }

                sbu.append(" ");

                ++i;
            }
        }

        return sbu.toString();
    }
}
