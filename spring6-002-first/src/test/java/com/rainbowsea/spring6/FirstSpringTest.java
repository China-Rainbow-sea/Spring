package com.rainbowsea.spring6;

import com.rainbowsea.spring6.bean.User;
import com.rainbowsea.spring6.bean.UserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import java.text.SimpleDateFormat;
import java.util.Date;


public class FirstSpringTest {

    @Test
    public void test02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        // 第二步：
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testFirstSpringCode() {
        // 第一步:获取到Spring 容器对象
        // ApplicationContext 翻译为: 应用上下文,其实就是
        // ApplicationContext 是一个接口:
        // ApplicationContest 接口下有很多实现类,其中有一个实现类叫做:ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext 专门从类路径当中加载Spring 配置文件的一个类
        // 下面这行代码只要执行,就相当与启动了/Spring 容器,解析Spring.xml 文件.
        // 面向接口编程,左边的是接口,右边的类
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        /**
         * 源码分析:
         *     public ClassPathXmlApplicationContext(String... configLocations) throws BeansException {
         *         this(configLocations, true, (ApplicationContext)null);
         *     }
         *     可变参数,说明可以传入多个参数西信息;
         *
         */


        // 第二步: 根据bean 的id从Spring 的容器中获取到这个对象
        // 注意:这个name ,尽量使用 copy 的方式,防止发生错误
        Object userBean = applicationContext.getBean("userBean");

        System.out.println(userBean);

        // 再获取到Spring 容器当中的对象
        Object userDaoBean = applicationContext.getBean("userDaoBean");
        System.out.println(userDaoBean);
    }


    @Test
    public void test() {
        //第一步获取到Spring 的配置文件信息的容器对象
        // 可变参数,的构造器可以传多个变量
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml","beans.xml");

        // 第二步:通过Spring 创建对象,建议使用 copy 的方式
        // 获取到 beans.xml 中的配置文件信息
        Object userBean2 = applicationContext.getBean("userBean2");
        System.out.println(userBean2);

        // 获取到 spring.xml 中的配置文件信息
        Object userDaoBean = applicationContext.getBean("userDaoBean");
        System.out.println(userDaoBean);
    }


    @Test
    public void test2() {
        // 读取在根路径下,包含了子目录的.xml 配置文件的时候,需要指明配置文件当中子目录
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/bean.xml","spring.xml");

        // 获取到resources 根目录下的 spring.xml 的配置文件信息
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        // 获取到 resources/xml根目录下的子目录
        Object vipBean = applicationContext.getBean("vipBean");
        System.out.println(vipBean);


        // 获取到 jdk 自带当中的 javabean ,或者是其他 jar包当中的类
        Object nowTine = applicationContext.getBean("nowTine");
        System.out.println(nowTine);

        // 日期格式化:
        // 注意:类型的转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String format = simpleDateFormat.format((Date) nowTine);
        System.out.println(format);


        System.out.println("************************");
        // 如果你不想强制类型转换的话:我们可以使用如下方式:
        // 通过第二个参数来指定返回的 bean 的类型:
        Date nowTine1 = applicationContext.getBean("nowTine", Date.class);
        String format1 = simpleDateFormat.format(nowTine1);
        System.out.println(format1);
    }



    @Test
    public void test3() {
        // 如果对应编写的 id 是不存在的的,也就是编写错误了的话,返回的不是 null,而是报异常
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object userBean = applicationContext.getBean("userBean");

        System.out.println(userBean);

        //User userBean1 = applicationContext.getBean("userBean2", User.class);
        //System.out.println(userBean1);
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
        userDao.insert();
    }


    /**
     * 通过决定路径读取的读取配置文件信息
     */
    @Test
    public void test4() {
        // FileSystemlApplicotionContext 不是从类路径当中加载资源的
        // 这种方式很少用。了解即可
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\Java\\Spring6\\spring6-002" +
                "-first\\src\\main\\resources/spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        // ApplicationContext 接口的超级父接口，BeanFactroy （翻译为:Bean工厂，就是能够生产Bean对象的一个工厂对象）
        // BeanFactory 是 IOC 容器的顶级接口:
        // Spring 的 IOC 容器底层实际上使用了 工厂模式
        // Spring 底层的IOC是怎么实现？  ： 工厂模式 + XML 解析 + 反射机制



    }

    @Test
    public void test5() {
        // 注意：不是在调用getBean()方法的时候被创建对象，执行以下代码的时候，就是实例化对象
        new ClassPathXmlApplicationContext("spring.xml");
    }


    @Test
    public void testBeginInitBean() {
        // 你自己怎么去使用log4je 记录日志信息呢？
        // 第一步: 创建日志记录器对象
        // 获取FirstSpringTest 类的日志记录器对象，也就是说只要是FirstSpring 类中的代码
        // 行记录日志的话，就输出相关的日志信息。
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

        // 第二步:记录日志，根据不同的级别来输出日志
        logger.info("我是一条信息");
        logger.debug("我是一条调试信息");
        logger.error("我是一条错误信息");

    }

}


