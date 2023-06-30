package com.rainbowsea.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class UserDao {

    // 日志框架log4j
    // 记录当前User.class 类的日志信息,
    // 注意不要导错包了.是: import org.slf4j.LoggerFactory;
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    public void insert() {
        // 使用以下 log4j2 日志框架
        logger.info("数据库正在保存用户信息");
    }
}
