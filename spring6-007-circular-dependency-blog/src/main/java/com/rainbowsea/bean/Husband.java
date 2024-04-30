package com.rainbowsea.bean;

public class Husband {
    private String name;
    private Wife wife;


    public Husband() {
    }

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }


    // toString()方法重写时需要注意：不能直接输出wife，输出wife.getName()。要不然会出现递归导致的栈内存溢出错误
    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + this.wife.getName() +
                '}';
    }
}
