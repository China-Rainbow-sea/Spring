package com.rainbowsea.reflect.sprint.bean;


import org.springframework.stereotype.Service;


@Service("os")
public class Order {
    public Order() {
        System.out.println("Order 无参数构造方法执行");
    }
}
