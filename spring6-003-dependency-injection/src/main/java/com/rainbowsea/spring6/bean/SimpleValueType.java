package com.rainbowsea.spring6.bean;

import org.springframework.util.ClassUtils;

import java.net.URI;
import java.net.URL;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Locale;


/**
 * 如下的都是关于: Spring6 的简单类型的解释
 * 简单类型不能用 ref 进行赋值，而是使用 value 进行赋值
 */
public class SimpleValueType {
/*
所在类是: BeanUtils.
 如下的是: Spring6 认定的简单类型，注意: 简单类型不可以使用 ref 进行赋值
    public static boolean isSimpleValueType(Class<?> type) {
        return (Void.class != type && void.class != type &&
                (ClassUtils.isPrimitiveOrWrapper(type) ||
                        Enum.class.isAssignableFrom(type) ||
                        CharSequence.class.isAssignableFrom(type) ||
                        Number.class.isAssignableFrom(type) ||
                        Date.class.isAssignableFrom(type) ||
                        Temporal.class.isAssignableFrom(type) ||
                        URI.class == type ||
                        URL.class == type ||
                        Locale.class == type ||
                        Class.class == type));
    }*/


    private int age;
    private Integer age2;

    private boolean flag;
    private Boolean flag2;


    private char c;
    private Character c2;

    private Season season;  // 枚举

    private String username;

    private Class clazz;

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setFlag2(Boolean flag2) {
        this.flag2 = flag2;
    }

    public void setC(char c) {
        this.c = c;
    }

    public void setC2(Character c2) {
        this.c2 = c2;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }


    @Override
    public String toString() {
        return "SimpleValueType{" +
                "age=" + age +
                ", age2=" + age2 +
                ", flag=" + flag +
                ", flag2=" + flag2 +
                ", c=" + c +
                ", c2=" + c2 +
                ", season=" + season +
                ", username='" + username + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
