package com.rainbowsea.factoy.method;


/**
 * 具体产品角色：枪
 */
public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("枪攻击");
    }
}
