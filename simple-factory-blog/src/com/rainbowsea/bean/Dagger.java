package com.rainbowsea.bean;


/**
 * 具体产品: 匕首
 * 同样继承 Weapon 抽象武器产品，保持同性
 */
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("Dagger 匕首攻击");
    }
}
