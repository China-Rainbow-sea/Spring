package com.rainbowsea.bean;

public class Cat {

    private int age;
    private String name;

    // set注入：底层反射调用 set 方法
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
