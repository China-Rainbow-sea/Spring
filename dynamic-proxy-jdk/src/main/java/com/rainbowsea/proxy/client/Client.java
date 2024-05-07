package com.rainbowsea.proxy.client;

import com.rainbowsea.proxy.service.OrderService;
import com.rainbowsea.proxy.service.OrderServiceImp;
import com.rainbowsea.proxy.service.TimerInvocationHandler;
import com.rainbowsea.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

public class Client {
    // 客户端程序
    public static void main(String[] args) {
        // 创建目标对象
        OrderService target = new OrderServiceImp();

        // 创建代理对象
        //Proxy.newProxyInstance(类加载器,代理类要实现的接口,调用处理器);

        /*
        newProxyInstance 翻译为：新建代理对象
        也就是说：通过调用这个方法可以创建代理对象
        本质上，这个Proxy.newProxyInstance()方法的执行，做了两件事
                第一件事：在内存中动态的生成一个代理类的字节码class
                第二件事：new 对象了，通过内存中生成的代理类这个代码，实例化了代理对象
          2.关于 newProxyInstance()方法的三个重要的参数， 每一个什么含义，有什么用？
                第一个参数：ClassLoader Loader
                类加载器，这个类加载器有什么用呢？
                    在内存当中生成的字节码也就是class文件，要执行也得先加载到内存当中，加载类就需要
                    类加载器，所以这里需要指定类加载器。并且用JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个
                第二个参数：Class<?>[] interfaces
                    代理类和目标类要实现同一个接口或同一些接口
                    在内存中生成代理类的时候，这个代理类是需要你告诉它实现哪些接口的
                第三个参数：InvocationHandler h
                    InvocationHandler 被翻译为：调用处理器，是一个接口
                    在调用处理器接口中编写的就是：增强代码
                    因为具体要增强什么代码，JDK动态代理技术它是猜不到的，没有那么神
                    既然是接口，就要写接口的实现类。

                    可能会疑问？
                        自己还要动手写调用处理器接口的实现类，这不会类爆炸吗？不会
                        因为这种调用处理器是写一次就好了。

         */
        // 注意：代理对象和目标对象都实现了共同的接口，接口是一样的看，所以可以向下转型
        //OrderService proxy = (OrderService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
        //        target.getClass().getInterfaces(),
        //        new TimerInvocationHandler(target));

        OrderService proxy = (OrderService) ProxyUtil.newProxyInstance(target);
        // 虽然这里的    new TimerInvocationHandler() 可以用Lamda表达式写，但是这么做的复用性，并没有
        //单独写好为一个类，复用性高

        // 调用代理对象的代理方法
        // 注意：调用代理对象的代理方法的时候，如果你要做增强的话，弥补对象的目标方法得保证执行。
        proxy.generate();
        proxy.modify();
        proxy.detail();
        String name = proxy.getName();

        System.out.println(name);


    }
}
