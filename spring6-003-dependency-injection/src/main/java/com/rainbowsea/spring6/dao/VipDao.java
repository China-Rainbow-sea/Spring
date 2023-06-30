package com.rainbowsea.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VipDao {

    // 获取到该Vip类的日志信息框架
    private static final Logger logger = LoggerFactory.getLogger(VipDao.class);

    public void insert() {
        logger.info("正在保存vip 信息");
    }



}
