package com.rainbowsea.proxy.service;


/**
 * 代理对象（代理对象和目标对象要具有相同的行为，就要实现同一个或同一些接口）
 * 客户端在使用代理对象的时候就像在使用目标对象一样。
 */
public class OrderServiceProxy implements OrderService{

    // 将目标对象作为代理对象的一个属性，这种关系叫做关联关系，比继承关系的耦合度低
    // 代理对象中含有目标对象的引用。关联关系：has a
    private OrderService target;  //  这就是目标对象，

    // 创建代理对象的时候，传一个目标对象给代理对象
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() { // 代理方法
        // 增强
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - begin) + "毫秒");

    }

    @Override
    public void modify() {  // 代理方法
        // 增强
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {  // 代理方法
        // 增强
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - begin) + "毫秒");
    }
}
