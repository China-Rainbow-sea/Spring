package com.rainbowsea.bean;

public class Zoon {

    private String zoonName;
    private Cat cat;


    // set 注入，必须要提供 set() 方法
    public void setZoonName(String zoonName) {
        this.zoonName = zoonName;
        System.out.println("setZoonName () 方法被调用了");
    }

    public void setCat(Cat cat) {
        this.cat = cat;
        System.out.println("setCat() 方法别调用了");
    }

    @Override
    public String toString() {
        return "Zoon{" +
                "zoonName='" + zoonName + '\'' +
                ", cat=" + cat +
                '}';
    }
}
