package com.rainbowsea.spring6.test;

import com.rainbowsea.spring6.bean.Date.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDate {


    /***
     * 在Spring当中，第四种：获取Bean的方法：通过 FactoryBean 接口来获取
     */
    @Test
    public void testInstantiation5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springDate.xml");
        Student student2 = applicationContext.getBean("student2", Student.class);
        System.out.println(student2);
    }


    /**
     * Date 当作简单类型处理
     */
    @Test
    public void dateTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springDate.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }
}
