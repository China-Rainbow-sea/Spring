package com.rianbowsea.spring6.test;

import com.rainbowsea.bank.service.AccountService;
import com.rainbowsea.bank.service.impl.AccountServicelmpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankTxTest {

    @Test
    public void testNoAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spirng6.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountServicelmpl", AccountServicelmpl.class);
        try {
            accountService.transfer("act-001","act-002",10000.0);
        } catch (Exception e) {
            System.out.println("转账失败");
            e.printStackTrace();
        }
    }
}
