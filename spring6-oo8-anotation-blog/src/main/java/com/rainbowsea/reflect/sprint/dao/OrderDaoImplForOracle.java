package com.rainbowsea.reflect.sprint.dao;


import org.springframework.stereotype.Repository;

@Repository(value = "orderDaoImplForOracle")
public class OrderDaoImplForOracle implements OrderDao {


    @Override
    public void insert() {
        System.out.println("oracle 保存订单信息");
    }
}
