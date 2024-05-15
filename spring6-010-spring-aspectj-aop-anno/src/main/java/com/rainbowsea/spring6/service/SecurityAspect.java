package com.rainbowsea.spring6.service;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("securityAspect")  // 交给Spring管理
@Aspect // 切面类是需要使用Aspect 注解进行标注的
@Order(2)
public class SecurityAspect {  // 安全切面

    // 切面 =  通知+切点
    @Before("execution(* com.rainbowsea.spring6.service..*(..))")
    public void beforeAdvice() {
        System.out.println("前置通知，安全...");
    }
}
