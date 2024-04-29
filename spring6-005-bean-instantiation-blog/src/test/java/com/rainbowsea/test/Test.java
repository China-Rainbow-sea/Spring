package com.rainbowsea.test;

import com.rainbowsea.Bean.User;
import com.rainbowsea.Bean.myDate.Vip;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Test {


    @org.junit.Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
    }


    @org.junit.Test
    public void test2() {
        System.out.println(new Date());
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("userFactory", User.class);
        System.out.println(user);
    }
}
