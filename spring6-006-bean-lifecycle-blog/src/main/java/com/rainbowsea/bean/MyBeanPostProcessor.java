package com.rainbowsea.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // Object bean 是 该对应的 bean 的对象
        // String beanName 是该对应 bean 的在配置文件当中 id
        System.out.println("第四步:  Bean 初始化之前执行before()方法");

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Object bean 是 该对应的 bean 的对象
        // String beanName 是该对应 bean 的在配置文件当中 id
        System.out.println("第七步:  Bean 初始化之后执行after() 方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
