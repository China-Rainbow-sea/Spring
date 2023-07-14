package com.rainbowsea.spring.text;

import com.rainbowsea.spring6.jdbc.MyDataSource;
import com.rainbowsea.spring6.jdbc.MyDataSource01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest03 {


    @Test
    public void testProperties() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }

    @Test
    public void testUtil2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util2.xml");
        MyDataSource01 dis = applicationContext.getBean("dis", MyDataSource01.class);
        System.out.println(dis);

        MyDataSource01 dis2 = applicationContext.getBean("dis2", MyDataSource01.class);
        System.out.println(dis2);
    }


    @Test
    public void testUtil() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource01 dis = applicationContext.getBean("dis", MyDataSource01.class);
        System.out.println(dis);

        MyDataSource01 dis2 = applicationContext.getBean("dis2", MyDataSource01.class);
        System.out.println(dis2);
    }
}
