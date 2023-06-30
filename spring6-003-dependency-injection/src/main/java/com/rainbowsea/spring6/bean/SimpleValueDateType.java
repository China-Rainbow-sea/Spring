package com.rainbowsea.spring6.bean;

import java.util.Date;

public class SimpleValueDateType {
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "SimpleValueDateType{" +
                "birth=" + birth +
                '}';
    }
}
