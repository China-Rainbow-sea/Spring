package com.rainbowsea.bean;


/**
 * 具体工厂角色（武器坦克）
 */
public class Tank extends Weapon{

    @Override
    public void attack() {
        System.out.println("Tank 坦克攻击");
    }
}
