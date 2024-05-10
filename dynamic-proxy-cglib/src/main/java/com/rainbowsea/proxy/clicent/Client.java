package com.rainbowsea.proxy.clicent;

import com.rainbowsea.proxy.service.TimerMethodInterceptor;
import com.rainbowsea.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;

public class Client {

    public static void main(String[] args) {
        // 创建字节码增强器对象
        // 这个对象是CGLIB库当中的核心对象，就是依靠它李生成代理类
        Enhancer enhancer = new Enhancer();

        // 告诉CGLIB父类是谁，告诉CGLIB目标类是谁
        enhancer.setSuperclass(UserService.class);

        // 设置回调（等同于JDK动态代理当中的调用处理器：invocationHandler）
        //在CGLIB当中不是invocationHandler 接口，是方法拦截器接口，MethodInterceptor
        enhancer.setCallback(new TimerMethodInterceptor());


        // 创建代理对象
        // 这一步会做两件事
        /*
            第一件事: 在内存中生成UserService类的子类，其实就是代理类的字节码
            第二件事: 创建代理对象。
            父类是UserService ，子类这个代理类一定是UserService
         */
        UserService userServiceProxy = (UserService) enhancer.create();



        // 调用代理对象的代理方法
        boolean success = userServiceProxy.login("admin", "123");
        System.out.println(success ? "登录成功" : "登录失败");

        userServiceProxy.logout();

    }
}
