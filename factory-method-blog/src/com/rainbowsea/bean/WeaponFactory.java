package com.rainbowsea.bean;


/**
 * 武器工厂的接口
 * 统一武器工厂的生产
 */
public interface WeaponFactory {
    /**
     * 这个方法不是静态的，是实例方法,
     * 这里是简单工厂模式的最大的区别
     */
    Weapon get();
}
