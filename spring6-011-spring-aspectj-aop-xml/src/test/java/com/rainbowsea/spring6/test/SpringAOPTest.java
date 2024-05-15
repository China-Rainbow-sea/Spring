package com.rainbowsea.spring6.test;

import com.rainbowsea.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {


    @Test
    public void testXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.logout();
    }
}
