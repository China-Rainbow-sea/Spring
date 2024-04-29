package com.rainbowsea.Bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 特点：它是简单工厂模式(静态工厂模式)，是静态的一个方法
 *
 */
public class UserFactory implements FactoryBean<User> {


    @Override
    public User getObject() throws Exception {
        // 本质上还是我们程序员自己 new ()出来的，并不是 Spring 弄出来
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;  // 单例
    }

}
