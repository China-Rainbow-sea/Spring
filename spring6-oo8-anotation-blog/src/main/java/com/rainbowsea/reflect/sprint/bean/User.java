package com.rainbowsea.reflect.sprint.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "userBean")
public class User {


    private String name;


    private int age;


    @Autowired
    private Vip vip;


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", vip=" + vip +
                '}';
    }
}
