package com.rainbowsea.test;

import com.rainbowsea.reflect.Spring6Configuration;
import com.rainbowsea.reflect.sprint.dao.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {
    public void testIoCAnnotation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Configuration.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }


    @Test
    public void testIoCAnnotation2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring3.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();


    }
}
