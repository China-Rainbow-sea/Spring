package com.rainbowsea.bean;


/**
 * 具体工厂角色（武器匕首）
 */
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("Dagger 匕首攻击");
    }
}
