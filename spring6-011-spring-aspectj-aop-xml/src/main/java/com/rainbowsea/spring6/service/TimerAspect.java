package com.rainbowsea.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAspect {
    // 通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前环绕
        long begin = System.currentTimeMillis();

        // 目标执行
        joinPoint.proceed();

        // 后环绕

        long end = System.currentTimeMillis();

        System.out.println("耗时 " + (end - begin) + "毫秒");

    }
}
