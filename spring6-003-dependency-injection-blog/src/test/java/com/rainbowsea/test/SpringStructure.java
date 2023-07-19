package com.rainbowsea.test;

import com.rainbowsea.bean.MyDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStructure {

    @Test
    public void test() {
        // 获取到对应的 spring6当中的xml的，容器对象
        // 面向接口编程，左边为接口，
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-sets.xml");
        // 通过 id 获取到对应的类/class
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);


    }
}
