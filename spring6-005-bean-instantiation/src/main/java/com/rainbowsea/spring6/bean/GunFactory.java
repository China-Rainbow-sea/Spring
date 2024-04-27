package com.rainbowsea.spring6.bean;


/**
 * 工厂方法模式当中的：具体工厂角色
 */
public class GunFactory {

    // 工厂方法模式中的具体工厂角色中的方法是：实例方法
    public Gun get() {
        // 和静态工厂方法模式是一样的：都是我们自己程序员 new 的。
        // 然后交给 Spring框架管理
        return new Gun();
    }
}
