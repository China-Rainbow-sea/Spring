package com.rainbowsea.spring6.test;

import com.rainbowsea.spring6.bean.Student;
import com.rainbowsea.spring6.bean.User;
import com.rainbowsea.spring6.bean.Vip;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {


    /*
    Spring容器只对singleton的Bean 进行完整的生命周期管理
    如果是prototype作用域的Bean,Spring容器只负责将该Bean初始化完毕，等客户端
    程序一旦获取到Bean之后，Spring容器不再管理该对象的生命周期了。
     */
    @Test
    public void testRegisterBean() {
        // 自己 new 的对象
        Student student = new Student();
        System.out.println(student);

        // 将以上自己 new 的这个对象纳入 Spring 框架容器当中去管理，半路上交给 Spring来管理
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerSingleton("studentBean",student);

        // 从Spring 容器中获取:通过上述我们 registerSingleton()方法中定义的id，进行一个获取
        Object studentBean = defaultListableBeanFactory.getBean("studentBean");
        System.out.println(studentBean);
        // 单例：地址是一样的。
    }



    @Test
    public void testBeanLifecycleFive2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        Vip vip = applicationContext.getBean("vip", Vip.class);
        System.out.println(vip);
    }



    @Test
    public void testBeanLifecycleFive() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第八步: 使用Bean" + user);

        // 注意: 必须手动关闭Spring框架，这样Spring容器才会销毁Bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();

    }
}
