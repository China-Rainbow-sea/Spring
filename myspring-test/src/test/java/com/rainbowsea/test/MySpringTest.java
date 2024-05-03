package com.rainbowsea.test;


import com.rainbowsea.myspring.bean.OrderService;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object vip = applicationContext.getBean("vip");
        System.out.println(vip);

        OrderService orderServer = (OrderService) applicationContext.getBean("orderServer");
        orderServer.generate();

    }
}
