package com.rainbowsea.spring6.bean;


import org.springframework.stereotype.Component;

@Component(value = "user")   // 交给 Spirng IOC 容器管理
public class User {
    private String name = "张三";

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
