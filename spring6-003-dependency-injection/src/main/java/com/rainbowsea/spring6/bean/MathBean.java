package com.rainbowsea.spring6.bean;

public class MathBean {
    private String result;


    // set 注入必须要有 set 方法


    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MathBean{" +
                "result='" + result + '\'' +
                '}';
    }
}
