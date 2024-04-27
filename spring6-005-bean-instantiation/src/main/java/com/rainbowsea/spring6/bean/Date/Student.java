package com.rainbowsea.spring6.bean.Date;

import java.util.Date;

public class Student {


    // java.util.Date 在Spring 当中被当前简单类型。但是简单类型的话，注入的日期字符串
    // 格式有要求
    // java.util.Date 在Spring 当中也可以被当前非简单类型

    private Date birth;


    public void setBirth(Date birth) {
        this.birth = birth;
    }


    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
