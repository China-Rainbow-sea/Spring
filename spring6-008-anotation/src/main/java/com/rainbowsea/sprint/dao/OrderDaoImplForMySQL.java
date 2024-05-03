package com.rainbowsea.sprint.dao;


import org.springframework.stereotype.Repository;

@Repository(value = "orderDaoImplForMySQL")
public class OrderDaoImplForMySQL implements OrderDao{

    @Override
    public void insert() {
        System.out.println("MySQL数据库正在保存订单信息");
    }
}
