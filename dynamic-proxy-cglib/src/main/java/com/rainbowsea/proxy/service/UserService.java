package com.rainbowsea.proxy.service;

public class UserService {
    // 目标方法
    public boolean login(String username,String password) {
        System.out.println("系统正在验证身份...");

        if("admin".equals(username) && "123".equals(password)) {
            return true;
        }

        return false;
    }


    // 目标方法
    public void logout() {
        System.out.println("系统正在退出...");
    }
}
