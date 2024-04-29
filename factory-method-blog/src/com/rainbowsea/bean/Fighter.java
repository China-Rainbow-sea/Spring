package com.rainbowsea.bean;


/**
 * 具体产品：战斗机
 */
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("Fighter 战斗机攻击");
    }
}
