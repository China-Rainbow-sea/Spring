package com.rainbowsea.spring6.test;

import com.rainbowsea.sprint.bean.Order;
import com.rainbowsea.sprint.bean.Student;
import com.rainbowsea.sprint.bean.User;
import com.rainbowsea.sprint.bean.Vip;


import com.rainbowsea.sprint.dao.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {


    @Test
    public void testBeanComponent() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);

        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);


        Order orderBean = applicationContext.getBean("os", Order.class);
        System.out.println(orderBean);


        Student studentBean = applicationContext.getBean("student", Student.class);
        System.out.println(studentBean);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        System.out.println(orderService);

    }

}
