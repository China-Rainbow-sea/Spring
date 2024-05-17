package com.rainbowsea.spring6.service;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
//@Component(value = "myAspect") // 纳入 Spring IOC 容器当中管理
//@Aspect // 开启事务通知
public class MyAspect {
    // 这就是需要增强的代码（通知）

    // 定义通用的切点表达式
    @Pointcut("execution(* com.rainbowsea.spring6.service..*(..))")
    public void pointcut(){
        // 这个方法只是一个标记，方法名随意，方法体也不需要写任何代码。
    }

    // 前置通知
    // 安全
    @Before("pointcut()")
    public void beforeAdvice() {
        System.out.println("前置通知");
    }


    // 后置通知
    @AfterReturning("pointcut()")
    public void afterReturningAdvice() {
        System.out.println("后置通知");
    }


    // 环绕通知（环绕是最大的通知，在前置通知之前，在后置通知之后）
    @Around("pointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前面的代码
        System.out.println("前环绕");

        // 执行目标
        joinPoint.proceed(); // 执行目标

        // 后面的代码
        System.out.println("后环绕");
    }


    // 异常通知
    @AfterThrowing("pointcut()")
    public void afterThrowignAdvice() {
        System.out.println("异常通知");

    }


    // 最终通知（finally 语句块中的通知）
    @After(("pointcut()"))
    public void afterAdvice() {
        System.out.println("最终通知");
    }

}
