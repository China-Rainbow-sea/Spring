package com.rainbowsea.spring6.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "user")   // 交给 Spirng IOC 容器管理
public class User {
    @Value("张三") // spring 当中 value()注解简单类型的，set注入，赋值
    private String name;

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
