package com.rainbowsea.spring.text;

import com.rainbowsea.spring6.bean.Cat;
import com.rainbowsea.spring6.bean.Clazz;

import com.rainbowsea.spring6.bean.Dog;
import com.rainbowsea.spring6.bean.MathBean;
import com.rainbowsea.spring6.bean.People;
import com.rainbowsea.spring6.bean.QianDaye;
import com.rainbowsea.spring6.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest02 {

    @Test
    public void testC() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void test5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("special.xml");
        MathBean result = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println(result);
    }

    @Test
    public void test4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-null.xml");
        Cat catBean = applicationContext.getBean("catBean", Cat.class);
        System.out.println(catBean);
        // 验证赋值是否成功，是否为 null
        // toUpperCase() 将字符串转换为大写的。
        System.out.println(catBean.getName().toUpperCase());


    }


    @Test
    public void test3() {
        // 1. 获取到Spring6 容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        // 读取到Spring6 容器当中的id 对象
        Cat cat = applicationContext.getBean("person", Cat.class);
        System.out.println(cat);

    }

    @Test
    public void test2() {
        // 1.获取到Spring6容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        // 2.读取到Spring6容器当中id 对象
        QianDaye yuQian = applicationContext.getBean("yuQian", QianDaye.class);
        System.out.println(yuQian);

    }


    @Test
    public void test() {
        // 1.获取到该Spring容器对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        // 通过通过 id 获取都对象
        Student studentBean = classPathXmlApplicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);

        // 通过 id 获取到对象
        Clazz clazzBean = classPathXmlApplicationContext.getBean("clazzBean", Clazz.class);
        System.out.println(clazzBean);



    }
}
