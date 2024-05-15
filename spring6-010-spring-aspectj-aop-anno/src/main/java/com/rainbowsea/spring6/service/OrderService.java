package com.rainbowsea.spring6.service;


import org.springframework.stereotype.Service;

@Service(value = "orderService") // 交给Spring 管理
public class OrderService { // 目标类

    // 目标方法
    public void generate() {
        System.out.println("系统正在生成订单...");

        //if(1 == 1) {
        //    throw new RuntimeException("运行异常...");
        //}
    }
}
