package com.rainbowsea.spring.text;

import com.rainbowsea.spring6.bean.SimpleValueDateType;
import com.rainbowsea.spring6.bean.SimpleValueType;
import com.rainbowsea.spring6.bean.User;
import com.rainbowsea.spring6.jdbc.MyDataSource;
import com.rainbowsea.spring6.service.CustomerService;
import com.rainbowsea.spring6.service.OrderService;
import com.rainbowsea.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


public class SpringDITest {
    @Test
    public void testSetDI() {
        // 获取到Spring的配置文件对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceBean = applicationContext.getBean("userServiceBean", UserService.class);
        System.out.println(userServiceBean);
        userServiceBean.saveUser();
    }

    @Test
    public void testConstructorDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("csBean", CustomerService.class);
        customerService.save();
        System.out.println(customerService);

        System.out.println("*********************");


        CustomerService customerService2 = applicationContext.getBean("csBean", CustomerService.class);
        customerService.save();
        System.out.println(customerService2);

        CustomerService customerService3 = applicationContext.getBean("csBean", CustomerService.class);
        customerService.save();
        System.out.println(customerService3);

        CustomerService csBean2 = applicationContext.getBean("csBean2", CustomerService.class);
        csBean2.save();
        System.out.println(csBean2);

    }


    @Test
    public void test() {
        // 第一步: 读取到对应的Spring的 xml 文件信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        // 第二步: 通过set注入
        OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderServiceBean.generate();

    }

    @Test
    public void test2(){
        // 第一步: 读取到对应的Spring 的xml 文件信息
        // 左边是接口，面向接口编程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        // 第二步: 通过 set 注入:
        OrderService orderServiceBean2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderServiceBean2.generate();
    }

    @Test
    public void test3() {
        // 第一步: 获取到对应的 Spring 的xml 文件信息
        // 左边的是接口，面向接口编程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        // 第二步: 通过set 注入:
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }


    @Test
    public void test4(){
        // 第一步:获取到对应的 Spring 的xml 的文件信息
        // 左边的是接口，面向接口编程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        // 第二步: 通过 set 注入: 获取到对应的 xml中的 bean
        SimpleValueType svt = applicationContext.getBean("svt", SimpleValueType.class);
        System.out.println(svt);
    }


    @Test
    public void test5() {
        // 第一步: 获取到对应Spring 容器对象
        // 左边是接口，面向接口编程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        // 第二步: 通过 set 注入; 获取到对应的 xml 中的 bean 信息
        SimpleValueDateType birth = applicationContext.getBean("dateType", SimpleValueDateType.class);
        System.out.println(birth);


    }

    @Test
    public void test6() {
        System.out.println(new Date());

    }


    /**
     * 通过Spring 来管理我们的数据库信息
     */
    @Test
    public void test7() {
        // 第一步: 获取到 Spring当中容器对象
        // 左边是接口，面向接口编程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        // 第二步: 获取到 Spring 当中配置的 bean 对象
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }


}
