package com.rainbowsea.test;

import com.rainbowsea.bean.Weapon;
import com.rainbowsea.bean.WeaponFactory;

public class Test {
    public static void main(String[] args) {
        // 我们要坦克
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();  // 坦克攻击


        // 我们要匕首，拜托武器工厂给我们制造
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack(); // 匕首攻击

    }
}
