package com.rainbowsea.reflect.sprint.bean;


import org.springframework.stereotype.Component;

@Component(value = "userBean")
public class User {

    public User() {
        System.out.println("User 的无参数构造方法执行");
    }
}
