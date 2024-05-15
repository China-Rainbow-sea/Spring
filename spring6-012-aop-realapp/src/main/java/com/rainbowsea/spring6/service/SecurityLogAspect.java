package com.rainbowsea.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component(value = "securityLogAspect")  // 交给 spring 管理
@Aspect // 开启事务
public class SecurityLogAspect {

    // 在 com.rainbowsea.spring6.service..save*() 包下的任意类当中的，save* 开头的任意方法,参数任意
    @Pointcut("execution(* com.rainbowsea.spring6.service..save*(..))")
    public void savePointcut() {

    }

    // 在execution(* com.rainbowsea.spring6.service..delete*(..)) 包下的任意类当中的 delete*(..) 开头的任意方法，任意参数
    @Pointcut("execution(* com.rainbowsea.spring6.service..delete*(..))")
    public void deletePointcut() {

    }

    // execution(* com.rainbowsea.spring6.service..delete*(..)) 包下的任意类当中的modify*(..) 开头的任意方法，任意参数
    @Pointcut("execution(* com.rainbowsea.spring6.service..modify*(..))")
    public void modifyPointcut() {

    }





    // 联合使用，多个类当中的不同的方法名对应 AOP事务
    @Before("savePointcut() || deletePointcut() || modifyPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 系统时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss SSS");
        String nowTime = simpleDateFormat.format(new Date());

        // 输出日志信息
        System.out.println(nowTime + "zhangsan" + joinPoint.getSignature().getDeclaringTypeName()+
                "." + joinPoint.getSignature().getName());
    }
}
