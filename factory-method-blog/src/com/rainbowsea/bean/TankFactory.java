package com.rainbowsea.bean;


/**
 * 坦克的具体工厂角色：
 * 专门生产坦克的工厂
 */
public class TankFactory implements WeaponFactory{
    @Override
    public Weapon get() {
        return new Tank();
    }
}
