package com.rainbowsea.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,InitializingBean,DisposableBean{

    private String name;

    public User() {
        System.out.println("第一步: 无参构造方法执行");
    }

    public User(String name) {

        this.name = name;
    }


    /**
     * 这个方法需要自己写，方法名随意，但是注意写好之后，要配给Spring框架，让其知道这个东东
     */
    public void initBean() {
        System.out.println("第六步: 初始化Bean.");
    }

    /**
     * 这个方法需要自己写，方法名随意，但是注意写好之后，要配给Spring框架，让其知道这个东东
     */
    public void destroyBean() {
        System.out.println("第十步: 销毁Bean");
        //System.out.println("*******************************");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("第二步: 给对象的属性赋值");
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("第三步：检查是否实现了Aware的相关接口并调用其中的实现接口方法(): Bean 这个类的加载器" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第三步：检查是否实现了Aware的相关接口并调用其中的实现接口方法():  生产这个Bean的工厂对象是 " +beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("第三步：检查是否实现了Aware的相关接口并调用其中的实现接口方法():  这个Bean的名称是: " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第五步：检查Bean是否实现了InitializingBean 接口，并调用接口方法.afterPropertiesSet执行");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("第九步: 检查 Bean是否实现了DisposableBean接口，并调用接口方法 destroy()  ");
    }





  /*
  这个处理器是作用于，本身的这个 User Bean 的处理器的。
    @Override
    public void destroy() throws Exception {
        System.out.println("初始化 Bean的后一步执行: DisposableBean's destroy()的方法 ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //System.out.println("初始化 Bean的前一步执行: InitializingBean's afterPropertiesSet()的方法");
    }*/
}
