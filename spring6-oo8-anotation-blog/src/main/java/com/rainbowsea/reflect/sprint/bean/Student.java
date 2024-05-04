package com.rainbowsea.reflect.sprint.bean;


import org.springframework.stereotype.Repository;


// 注解的 value 省略的话，默认就是 student 类名的小写
// 如果你把整个 value 属性全部省略了，bean 有没有默认的名称？有
// 类名首字母变小写就是 bean 的名字。
@Repository(value = "studentBean")
public class Student {
    public Student() {
        System.out.println("Student的无参数构造方法执行");
    }
}

/**
 * 以上的 @Repository就相当域以下的配置信息
 * <bean id ="student" class="com.ranbowsea.spring.bean.Student"></bean>
 */
