package com.rainbowsea.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 专门赋值计时的一个调用处理器对象
 */
public class TimerInvocationHandler implements InvocationHandler {
    /*
    1.为什么强行要求你必须实现InvocationHandler 接口？
        因为一个类实现接口就必须实现接口中的方法
        以下这个方法必须是 invoke(),因为JDK在底层调用invoke()方法的程序已经提前写好了
        注意: invoke方法不是我们程序员负责调用，是JDK负责调用的
    2.invoke 方法什么时候被调用呢？
        当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke()方法被调用。
        proxy.generate();调用代理对象的代理方法
    3.invoke 方法的三个参数
        invoke 方法是JDK负责调用的，所以JDK调用这个方法的时候会自动给我们传过来这个三个参数
        我们可以往invoke 方法的大括号中直接使用。
        第一个参数:Object proxy 代理对象的引用，这个参数使用较少
        第二个参数:Method method 目标对象上的目标方法，（要执行的目标方法就是它）
        第三个参数：Object[] args 目标方法上的参数

     4. 我们可以看到这里并没有调用到目标方法的对象中的方法呀
     这个需要我们在增强代码中通过传的参数，自己调用目标对象/代理当中的目标方法。
     */

    // 目标对象
    private Object target;

    public TimerInvocationHandler(Object target) {
        // 赋值给成员变量
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke 执行...");
        return null;
    }




   /* @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long begin = System.currentTimeMillis();
        // 这个接口的目的就是为了让你有地方写增强代码
        // 调用目标对象上的目标方法;只要代理对象当中注册的InvocationHandler的方法被调用了，这里就会被调用
        // 方法四要素: 哪个对象，哪个方法，传什么参数，返回什么值
        Object reValue = method.invoke(target, args);

        long end = System.currentTimeMillis();

        System.out.println("耗时" + (end - begin) + "毫秒");

        // 注意：这个invoke方法的返回值，如果代理对象调用代理方法之后，需要返回结果的话，
        // invoke 方法必须将目标对象的目标方法执行结果继续返回
        return reValue;
    }*/
}
