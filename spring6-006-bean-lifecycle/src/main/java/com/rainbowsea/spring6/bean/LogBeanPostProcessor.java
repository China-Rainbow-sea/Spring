package com.rainbowsea.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("第四步: implements BeanPostProcessor  这个Bead 是" + bean);
        System.out.println("第四步: implements BeanPostProcessor 这个bean的名字" + beanName);
        System.out.println("第四步: implements BeanPostProcessor Bean 初始化之前处理：的before方法执行，即将开始初始化");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第七步：初始化 Bean的后一步执行: implements BeanPostProcessor ：这个Bead 是" + bean);
        System.out.println("第七步：初始化 Bean的后一步执行: implements BeanPostProcessor ：初始化 Bean的后一步执行: implements BeanPostProcessor  这个bean的名字" + beanName);
        System.out.println("第七步：初始化 Bean的后一步执行: implements BeanPostProcessor ： 初始化 Bean的后一步执行: implements " +
                "BeanPostProcessor Bean 初始化之后处理：的before方法执行");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
