package com.rainbowsea.spring6.test;

import com.rainbowsea.spring6.bean.Husband;
import com.rainbowsea.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {
    @Test
    public void testCircularDependency() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        System.out.println(husbandBean);


        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(wifeBean);

    }
}
