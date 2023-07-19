package com.rainbowsea.bean;

import java.util.Properties;

public class MyDataSource02 {
    private Properties properties;


    // set 注入必须提供 set方法
    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    @Override
    public String toString() {
        return "MyDataSource02{" +
                "properties=" + properties +
                '}';
    }
}
