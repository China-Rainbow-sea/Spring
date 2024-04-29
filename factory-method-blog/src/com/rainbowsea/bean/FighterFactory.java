package com.rainbowsea.bean;


/**
 * 具体工厂：
 * 生产战斗机的具体工厂
 */
public class FighterFactory implements WeaponFactory{
    @Override
    public Weapon get() {
        return new Fighter();
    }
}
