package com.rainbowsea.spring6.service;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 安全事务
 */
@Component // 将该 Bean 交给Spring IOC 容器管理上
//@Aspect // 开启事务
//@Order(1) // 数值越小，优先级越高，越先执行
public class SecureAspect {

    // 前置通知
    // 安全
    @Before("execution(* com.rainbowsea.spring6.service..*(..))")
    public void beforeAdvice() {
        System.out.println("安全方面的:前置通知");
    }
}
