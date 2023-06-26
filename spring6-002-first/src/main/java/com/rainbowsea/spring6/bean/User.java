package com.rainbowsea.spring6.bean;


/**
 * 这是一个bean ，封装了用户的信息，Spring 可以帮助我们创建User对象吗？
 *
 */
public class User {

    // Spring 是怎么实例化对象的?
    // 默认情况下Spring 是通过反射机制,调用类的无参数构造方法来实例化对象的
    // 所以,对于反射来说,我们来要有,一定要有私有的构造器
    // Class<?> clazz = Class.forName("com.rainbowsea.spring6.bean.User");
    //        Object o = clazz.newInstance();

    public User () {
        System.out.println("User 的无参数构造器构造方法的执行");
    }
}
