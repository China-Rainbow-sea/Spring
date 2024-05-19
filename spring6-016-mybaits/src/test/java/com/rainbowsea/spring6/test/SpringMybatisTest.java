package com.rainbowsea.spring6.test;

import com.rainbowsea.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisTest {

    @Test
    public void testSpringMybatis() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        // AccountService.class 左右两边保持一致性
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try {
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
