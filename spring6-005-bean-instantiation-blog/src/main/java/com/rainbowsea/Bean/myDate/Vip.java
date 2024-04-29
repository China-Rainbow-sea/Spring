package com.rainbowsea.Bean.myDate;

import java.util.Date;

public class Vip {

    private Date birth;

    public Vip(Date birth) {
        this.birth = birth;
    }

    public Vip() {
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "birth=" + birth +
                '}';
    }
}
