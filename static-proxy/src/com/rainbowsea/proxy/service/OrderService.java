package com.rainbowsea.proxy.service;


/**
 * 订单业务接口
 */
public interface OrderService {  // 目标接口

    /**
     * 生产订单
     */
    void generate();


    /**
     * 修改订单信息
     */
    void modify();

    /**
     * 查看订单详情
     */
    void detail();
}
