package com.rainbowsea.bean;


/**
 * 具体产品角色：坦克
 * 同时具体产品要继承 抽象武器产品，保持武器的同性
 */
public class Tank extends Weapon {

    @Override
    public void attack() {
        System.out.println("Tank 坦克攻击");
    }
}
