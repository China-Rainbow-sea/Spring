package com.rainbowsea.test;

import com.rainbowsea.spring6.service.OrderService;
import com.rainbowsea.spring6.service.Spring6Config;
import com.rainbowsea.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {

    @Test
    public void testNoXml() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }


    @Test
    public void testBefore2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
        userService.logout();





    }


    @Test
    public void testBefore() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //UserService userService = applicationContext.getBean("userService", UserService.class);
        //userService.login();
        //userService.logout();

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();



    }
}
