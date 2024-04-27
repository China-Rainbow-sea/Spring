package com.rainbowsea.spring6.test;

import com.rainbowsea.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

    @Test
    public void testBeanLifecycleFive() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第四步: 使用Bean" + user);

        // 注意: 必须手动关闭Spring框架，这样Spring容器才会销毁Bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();

    }
}
