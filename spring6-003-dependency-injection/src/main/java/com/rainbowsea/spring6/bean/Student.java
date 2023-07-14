package com.rainbowsea.spring6.bean;

public class Student {

    private String name;

    // 学生的班级:
    private Clazz clazz;


    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}

