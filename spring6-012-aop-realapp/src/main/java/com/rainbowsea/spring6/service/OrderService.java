package com.rainbowsea.spring6.service;


import org.springframework.stereotype.Service;

@Service(value = "orderService")  // 使用 @Service 注解，将该Bean交给 Spring IOC 容器管理
public class OrderService {  // 目标对象

    // 生成订单业务方法
    public void generate() {  // 目标方法
        System.out.println("正在生成订单...");
    }


    // 取消订单的业务的方法
    public void cancel() {  // 目标方法
        System.out.println("订单已取消");

    }
}
