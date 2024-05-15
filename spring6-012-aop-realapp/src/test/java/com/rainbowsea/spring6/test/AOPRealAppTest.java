package com.rainbowsea.spring6.test;

import com.rainbowsea.spring6.service.AccountService;
import com.rainbowsea.spring6.service.OrderService;
import com.rainbowsea.spring6.service.UserService;
import com.rainbowsea.spring6.service.VipService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPRealAppTest {

    @Test
    public void testSecurityLong() {
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring6.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        VipService vipService = applicationContext.getBean("vipService", VipService.class);

        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        userService.getUser();


        vipService.saveVip();
        vipService.saveVip();
        vipService.modifyVip();
        vipService.getVip();
    }

    @Test
    public void testTransaction() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        accountService.transfer();
        accountService.withdraw();

        orderService.generate();
        orderService.cancel();

    }
}
