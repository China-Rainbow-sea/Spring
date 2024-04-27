package com.rainbowsea.simple.factory;


/**
 * 战斗机
 */
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机攻击");
    }
}
