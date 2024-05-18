package com.rainbowsea.test;

import com.rainbowsea.bank.Spring6Config;
import com.rainbowsea.bank.pojo.Account;
import com.rainbowsea.bank.service.AccountService;
import com.rainbowsea.bank.service.impl.AccountServicelmpl;
import com.rainbowsea.bank.service.impl.IsolationService1;
import com.rainbowsea.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringTxTest {

    @Test
    public void testNoXml() {
        // Spring6Config.class 对应上的配置类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = applicationContext.getBean("AccountServicelmpl", AccountService.class);

        try {
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testIsolation1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act-005");
    }





    @Test
    public void testIsolation2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account act = new Account("act-005", 1000.0);
        try {
            i2.save(act);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPropagation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 获取1号 service 对象
        AccountService accountService = applicationContext.getBean("AccountServicelmpl", AccountService.class);
        Account account = new Account("act-003", 1000.0);

        accountService.save(account);
    }











    @Test
    public void testSpringTx() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        AccountService accountService = applicationContext.getBean("AccountServicelmpl", AccountService.class);

        try {
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
