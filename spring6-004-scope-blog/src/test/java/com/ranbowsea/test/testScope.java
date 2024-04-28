package com.ranbowsea.test;

import com.rainbowsea.spirngBean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testScope {
    @Test
    public void test() {
        // 第一个线程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("user", User.class);
        User user1 = applicationContext.getBean("user", User.class);
        System.out.println(user);
        System.out.println(user1);

        // 启动多线程
        // 第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user2 = applicationContext.getBean("user", User.class);
                User user3 = applicationContext.getBean("user", User.class);
                System.out.println(user2);
                System.out.println(user3);
            }
        }).start();

    }






    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("user", User.class);
        User user1 = applicationContext.getBean("user", User.class);
        System.out.println(user);
        System.out.println(user1);

        // 启动线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user2 = applicationContext.getBean("user", User.class);
                User user3 = applicationContext.getBean("user", User.class);
                System.out.println(user2);
                System.out.println(user3);
            }
        }).start();
    }
}
