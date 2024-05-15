package com.rainbowsea.spring6.service;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component(value = "logAspect")
@Aspect  // 切面类是需要使用@Aspect 注解进行标注的
@Order(1)  // 数字越小，优先级越高
public class LogAspect {  // 切面
    // 切面 = 通知 + 切点
    // 通知就是增强，就是具体的要编写的增强代码
    // 这里通知Advice以方法的形式出现，（因为方法中可以写代码）


    // @Before注解标注的方法就是一个前置通知
    //@Before(切点表达式)
    //@Before("execution(修饰符 返回值类型 全限定类名 方法名(形式参数列表)) 异常")
    //@Before("execution(* com.rainbowsea.spring6.service.UserService..*(..))")
    //public void 增强 () {
    //    System.out.println("我是一个通知，我是一段增强代码");
    //}


    // 定义通用的切点表达式
    @Pointcut("execution(* com.rainbowsea.spring6.service..*(..))")
    public void 通用切点表达式() {
        // 这个方法只是一个标记，方法名随意，方法体也不需要写任何代码。
    }




    // 前置通知
    @Before("通用切点表达式()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 这个JoinPoint joinPoint ，在Spring容器调用这个方法的时候自动传过来
        // 我们可以直接用，用这个 JoinPoint joinPoint 干啥？
        // Signature signature = joinPoint.getSignature(); 获取目标方法的签名
        // 通过方法的签名可以获取到一个方法的具体信息
        // 获取目标方法的方法名
        System.out.println("前置通知");
        System.out.println(joinPoint.getSignature().getModifiers());
        System.out.println("目标方法的方法名: "+joinPoint.getSignature().getName());
    }


  /*  @Before("execution(* com.rainbowsea.spring6.service..*(..))")
    public void beforeAdvice() {
        System.out.println("前置通知");
    }*/


    // 后置通知
    @AfterReturning("通用切点表达式()")
    public void afterReturningAdvice() {
        System.out.println("后置通知");
    }
  /*  @AfterReturning("execution(* com.rainbowsea.spring6.service..*(..))")
    public void afterReturningAdvice() {
        System.out.println("后置通知");
    }*/


    // 环绕通知（环绕是最大的通知，在前置通知之前，在后置通知之后）
    @Around("execution(* com.rainbowsea.spring6.service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前面的代码
        System.out.println("前环绕");

        // 执行目标
        joinPoint.proceed(); // 执行目标

        // 后面的代码
        System.out.println("后环绕");
    }


    // 异常通知
    @AfterThrowing("execution(* com.rainbowsea.spring6.service..*(..))")
    public void afterThrowignAdvice() {
        System.out.println("异常通知");

    }


    // 最终通知（finally 语句块中的通知）
    @After(("execution(* com.rainbowsea.spring6.service..*(..))"))
    public void afterAdvice() {
        System.out.println("最终通知");
    }
}
