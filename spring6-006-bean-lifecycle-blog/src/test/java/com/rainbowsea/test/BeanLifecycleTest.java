package com.rainbowsea.test;

import com.rainbowsea.bean.User;
import com.rainbowsea.bean.Vip;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

    @Test
    public void test() {
        // 第一步: 我们自己 new 一个对象，方便交给 spring 管理
        Vip vip = new Vip();
        System.out.println(vip);  // 打印一下地址，方便比较


        //  第二步:将以上自己 new 的这个对象纳入 Spring 框架容器当中去管理，半路上交给 Spring来管理
        //  通过 DefaultListableBeanFactory 这个对象，将我们 new 的对象交给 Spring 管理
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 通过: registerSingleton()方法，(这个交给 Spring 管理的bean的id/name 的命名,对于要交给spring管理的对象)

        defaultListableBeanFactory.registerSingleton("vipBean",vip);

        // 从Spring 容器中获取:通过上述我们 registerSingleton()方法中定义的id，进行一个获取
        Object vipBean = defaultListableBeanFactory.getBean("vipBean");
        System.out.println(vipBean);
        // 单例：地址是一样的。

    }


    @Test
    public void testRegisterBean2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println("第八步: 使用 User Bean 对象" + userBean);

        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
        // 注意点：这里的 close()方法是，ClassPathXmlApplicationContext 类才有的，它的ApplicationContext 父类没有。
        // 父类无法调用子类特有的方法，所以这里我们需要强制类型转换回来(向下转型)，为子类
        // 只有正常关闭spring容器才会执行销毁方法
        classPathXmlApplicationContext.close();


    }

    @Test
    public void testRegisterBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
    }

}
