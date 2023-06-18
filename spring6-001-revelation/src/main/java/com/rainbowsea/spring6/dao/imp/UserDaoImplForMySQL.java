package com.rainbowsea.spring6.dao.imp;

import com.rainbowsea.spring6.dao.UserDao;

public class UserDaoImplForMySQL implements UserDao {

    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除数据");
    }
}
