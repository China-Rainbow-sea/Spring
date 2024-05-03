package com.rainbowsea.reflect;

public class SomeService {

    public void doSome() {
        System.out.println("doSome() 方法被执行");
    }

    public String doSome(String name,int age) {
        return name + String.valueOf(age);
    }
}
