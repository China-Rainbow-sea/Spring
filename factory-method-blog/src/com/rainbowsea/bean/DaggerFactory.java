package com.rainbowsea.bean;


/**
 * 具体工厂角色
 * 生产匕首的工厂
 */
public class DaggerFactory implements WeaponFactory{
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
