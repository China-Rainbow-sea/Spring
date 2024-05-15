package com.rainbowsea.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component  // 交给Spring 管理
//@Aspect  // 开始AOP
public class TransactionAspect {

    // 编程式事务解决方案
    @Around("execution(* com.rainbowsea.spring6.service..*(..))")  // 环绕通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        // 执行目标
        try {

            // 前环绕
            System.out.println("开启事务");

            // 执行目标
            joinPoint.proceed();

            // 后环绕
            System.out.println("提交事务");



        } catch (Throwable throwable) {
            System.out.println("回滚事务");
            throwable.printStackTrace();
        }
    }
}
