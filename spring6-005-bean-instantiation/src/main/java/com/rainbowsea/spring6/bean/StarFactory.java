package com.rainbowsea.spring6.bean;

public class StarFactory {

    /**
     * 工厂类中有一个静态方法
     * 简单工厂模式又叫“静态工厂方法模式”
     * 注意点：这里是静态方法。
     * @return
     */
    public static Star get() {
        // 这个Star 说到底实际上创建的时候还是自己手动 new 的对象。
        return new Star();
    }
}
