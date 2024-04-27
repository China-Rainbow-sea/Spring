package com.rainbowsea.myspring6.test;

import com.rainbowsea.myspring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {


    /**
     * 不同线程，一个Bean
     */
    @Test
    public void testBeanScope2() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);


        // 启动一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb2);

                SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb3);
            }
        }).start();



    }


    @Test
    public void testBeanScope() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);


        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);


        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);

        /**
         * com.rainbowsea.myspring6.bean.SpringBean@2f16c6b3
         * com.rainbowsea.myspring6.bean.SpringBean@2f16c6b3
         * com.rainbowsea.myspring6.bean.SpringBean@2f16c6b3
         * 1.Spring 默认情况下是如何管理Bean的
         * 默认情况下Bean是“单例的”
         * 在Spring 上下文初始化的时候实例化
         * 每一次掉哟的getBean()方法的时候，获取返回的都是那个单例的对象
         * 当得bean的scope 上下文初始哈的是，并不会初始化这些prototype（多例）的Bean
         * 每一次调用getBean()方法的时候，实例化该bean对象。
         * prototype 翻译为“原型”
         */


        /**
         * com.rainbowsea.myspring6.bean.SpringBean@3c7c886c
         * com.rainbowsea.myspring6.bean.SpringBean@55493582
         * com.rainbowsea.myspring6.bean.SpringBean@1a20270e
         *
         */
    }



}
