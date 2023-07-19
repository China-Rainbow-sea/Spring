package com.rainbowsea.bean;

import java.util.Date;

public class TestDate {
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestDate{" +
                "date=" + date +
                '}';
    }
}
