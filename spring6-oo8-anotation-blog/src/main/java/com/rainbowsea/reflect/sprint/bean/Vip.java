package com.rainbowsea.reflect.sprint.bean;


import org.springframework.stereotype.Controller;

@Controller(value = "vipBean")
public class Vip {
    public Vip() {
        System.out.println("Vip 的无参数构造方法执行");
    }
}
