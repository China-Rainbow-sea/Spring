package com.rainbowsea.spring6.bean;

import java.util.Arrays;

public class QianDaye {
    private String[] aiHaoos;


    // 多个朋友
    private Woman[] womens;


    // set 注入需要: 对应的set方法()
    public void setWomens(Woman[] womens) {
        this.womens = womens;
    }

    public void setAiHaoos(String[] aiHaoos) {
        this.aiHaoos = aiHaoos;
    }

    @Override
    public String toString() {
        return "QianDaye{" +
                "aiHaoos=" + Arrays.toString(aiHaoos) +
                ", womens=" + Arrays.toString(womens) +
                '}';
    }
}
