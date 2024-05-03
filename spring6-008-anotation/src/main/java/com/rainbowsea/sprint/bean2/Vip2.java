package com.rainbowsea.sprint.bean2;


import org.springframework.stereotype.Service;

@Service(value = "vipBean2")
public class Vip2 {
    public Vip2() {
        System.out.println("vip2 构造方法执行");
    }
}
