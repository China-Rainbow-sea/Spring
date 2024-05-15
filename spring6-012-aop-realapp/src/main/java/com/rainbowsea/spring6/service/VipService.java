package com.rainbowsea.spring6.service;


import org.springframework.stereotype.Service;

@Service(value = "vipService")  // 被 spring管理
public class VipService {
    public void saveVip() {
        System.out.println("新增Vip用户信息");
    }



    public void deleteVip() {
        System.out.println("删除Vip用户信息");
    }


    public void modifyVip() {
        System.out.println("修改Vip用户信息");
    }



    public void getVip() {
        System.out.println("获取Vip用户信息");
    }
}
