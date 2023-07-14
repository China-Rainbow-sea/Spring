package com.rainbowsea.spring6.bean;

import java.util.Date;

public class Dog {

    // 简单的数据类型
    private  String name;

    private int age;

    // 设置为非简单的数据类型
    private Date date;

    // P命名空间注入底层，还是set注入，只不过P命名空间注入可以让spring配置变的更加简单。
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
