package com.rainbowsea.bean;


import java.util.Date;

public class People {


    private String name;
    private int age;
    private boolean sex;

    private Date date;

    // c命名空间底层调用的是构造方法，所以必须实现对应的构造方法
    public People(String name, int age, boolean sex, Date date) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.date = date;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", date=" + date +
                '}';
    }
}