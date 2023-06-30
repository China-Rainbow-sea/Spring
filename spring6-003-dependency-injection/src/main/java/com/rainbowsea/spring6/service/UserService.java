package com.rainbowsea.spring6.service;

import com.rainbowsea.spring6.dao.UserDao;
import com.rainbowsea.spring6.dao.VipDao;

public class UserService {
    private UserDao userDao = null;

    private VipDao vipDao = null;

    // set 注入的话:必须要提供一个set 方法.
    // Spring 容器会调用这个 set 方法,来给 userDao属性赋值.
    //我自己写一个 set 方法,不使用IDEA工具生成的,不符合javabean规范
    // 至少这个方法是以 set 单词开始的,注意:前三个字母不能随便写,必须是 "set"

    // 虽然我们可以随意命名，但是我们还是按照idea 自动生成的好，
    // 不要为难自己，
    //public void setMySQLUserDao(UserDao xyz) {
    //    this.userDao = xyz;
    //}


    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public void saveUser() {
        // 保存用户信息到数据库
        userDao.insert();
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }
}
