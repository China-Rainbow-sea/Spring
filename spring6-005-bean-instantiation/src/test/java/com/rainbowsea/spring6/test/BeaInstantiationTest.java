package com.rainbowsea.spring6.test;

import com.rainbowsea.spring6.bean.Gun;
import com.rainbowsea.spring6.bean.Person;
import com.rainbowsea.spring6.bean.SpringBean;
import com.rainbowsea.spring6.bean.Star;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeaInstantiationTest {




    @Test
    public void testInstantiation4() {
        // BeanFactory 顶级父类
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }



    /**
     * 第三种：Spring中当中获取到Bean: 通过 factory-bean 实例化
     */
    @Test
    public  void testInstantiation3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
        System.out.println(gun);
    }



    /**
     * 第二种：通过自己写的简单工厂模式，再通过指明哪个类，哪个方法factory-method=可以获取到你要的Bean
     */
    @Test
    public void testInstantiation2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star starBean = applicationContext.getBean("starBean", Star.class);
        System.out.println(starBean);
    }


    /**
     * 第一种：通过构造方法，获取到Bean
     */
    @Test
    public void testInstantiation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }
}
