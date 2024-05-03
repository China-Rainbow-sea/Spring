package com.rainbowsea.spring6.test;



import com.rainbowsea.Spring6Config;
import com.rainbowsea.service.StudentService;
import com.rainbowsea.sprint.bean2.User2;
import com.rainbowsea.sprint.bean3.MyDataSource;
import com.rainbowsea.sprint.bean3.People;
import com.rainbowsea.sprint.dao.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest2 {

    @Test
    public void testNoXML() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentService studentService = annotationConfigApplicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();

    }

    @Test
    public void test5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
        System.out.println(studentService);
    }


    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }
    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testDiByAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDatasourceBean = applicationContext.getBean("myDatasourceBean", MyDataSource.class);
        System.out.println(myDatasourceBean);


    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        User2 user2 = applicationContext.getBean("user2", User2.class);
        System.out.println(user2);

    }
}
