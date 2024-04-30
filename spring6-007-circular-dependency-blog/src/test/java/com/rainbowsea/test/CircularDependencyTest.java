package com.rainbowsea.test;

import com.rainbowsea.bean.Husband;
import com.rainbowsea.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {
    @Test
    public void testCircularDependency() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        System.out.println(husbandBean);


        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(wifeBean);
    }


}
