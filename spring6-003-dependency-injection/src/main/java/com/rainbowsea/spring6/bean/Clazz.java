package com.rainbowsea.spring6.bean;

public class Clazz {

    // 班级名词
    private String name;



    public void setName(String name) {
        this.name = name;
    }


    // 如果要使用级联属性赋值，这个需要用到 get方法
    // 不然无法使用
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }
}
