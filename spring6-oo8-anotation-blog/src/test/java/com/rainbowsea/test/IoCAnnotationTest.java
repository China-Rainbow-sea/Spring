package com.rainbowsea.test;

import com.rainbowsea.reflect.sprint.bean.Order;
import com.rainbowsea.reflect.sprint.bean.Student;
import com.rainbowsea.reflect.sprint.bean.User;
import com.rainbowsea.reflect.sprint.bean.Vip;
import com.rainbowsea.reflect.sprint.bean2.User2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {

    @Test
    public void testIoCAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");


    }
}
