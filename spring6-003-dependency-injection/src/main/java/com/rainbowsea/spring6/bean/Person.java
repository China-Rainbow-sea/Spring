package com.rainbowsea.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

    // 注入 List 集合
    private List<String> names;

    // 注入 Set 集合
    private Set<String> addrs;

    // 注入属性类对象
    // Properties 本质上也是一种Map集合
    // Properties 的父类Hashtable,Hashtable 实例了Map接口
    // 虽然这个也是一个Map集合,但是Map的注入方式有点像,但是不同,
    // Properties 的key 和 value 只能是String 类型
    private Properties properties;


    // set 注入需要:提供 set 方法:
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addrs=" + addrs +
                ", properties=" + properties +
                ", phones=" + phones +
                '}';
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

    private Map<Integer,String> phones;


    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }


}
