package com.rainbowsea.proxy.service;

public class OrderServiceImpSub extends OrderServiceImp{

    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        super.generate();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        super.modify();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        super.detail();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }
}
