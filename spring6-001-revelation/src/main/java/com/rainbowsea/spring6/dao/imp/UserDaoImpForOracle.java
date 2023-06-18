package com.rainbowsea.spring6.dao.imp;

import com.rainbowsea.spring6.service.UserService;

public class UserDaoImpForOracle implements UserService {

    @Override
    public void deleteUser() {
        System.out.println("Oracle正在删除数据");
    }
}
