package com.rainbowsea.test;

import com.rainbowsea.bean.DaggerFactory;
import com.rainbowsea.bean.FighterFactory;
import com.rainbowsea.bean.TankFactory;
import com.rainbowsea.bean.Weapon;
import com.rainbowsea.bean.WeaponFactory;

public class Test {
    public static void main(String[] args) {
        // 我们需要匕首
        // 调用匕首的工厂，进行生产
        WeaponFactory weaponFactory = new DaggerFactory();
        Weapon weapon = weaponFactory.get();
        weapon.attack();  // 匕首攻击


        // 我们需要坦克
        // 调用坦克的工厂，进行生产
        WeaponFactory weaponFactory2 = new TankFactory();
        Weapon weapon2 = weaponFactory2.get();
        weapon2.attack();  // 坦克攻击


        // 我们需要战斗机
        // 调用战斗机的工厂，进行生产
        WeaponFactory weaponFactory3 = new FighterFactory();
        Weapon weapon3 = weaponFactory3.get();
        weapon3.attack(); // 战斗机攻击

    }
}
