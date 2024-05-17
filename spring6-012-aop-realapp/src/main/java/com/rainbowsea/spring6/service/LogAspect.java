package com.rainbowsea.spring6.service;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 日志通知
 */
@Component // 将该 Bean 加入到 Spring IOC 容器当中管理
//@Aspect  // 开启事务
//@Order(2)  // 数值越小，优先级越高，越先执行
public class LogAspect {

    // 前置通知
    @Before("execution(* com.rainbowsea.spring6.service..*(..))")
    public void beforeAdvice() {
        System.out.println("日志的通知方面的：前置通知");
    }
}
