package com.rainbowsea.sprint.bean3;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "peopleBean")
public class People {
    private String name;
    private int age;

    // Could not autowire. No beans of 'String' type found.
    // @Value()注解可以用在构造方法上
    public People( @Value("张三") String name, @Value("30") int age) {
        this.name = name;
        this.age = age;
    }

    //@Value(value = "张三")  // Value 注解也可以用在注解上
    //public void setName(String name) {
    //    this.name = name;
    //}
    //
    ////@Value(value = "20")
    //public void setAge(int age) {
    //    this.age = age;
    //}


    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
