package com.rainbowsea.factoy.method;

public class Test {

    public static void main(String[] args) {

        // 匕首攻击
        WeaponFactory weaponFactory = new DaggerFactory();
        Weapon dagger = weaponFactory.get();
        dagger.attack();


        // 枪攻击
        WeaponFactory weaponFactory1 = new GunFactory();
        Weapon gun = weaponFactory1.get();
        gun.attack();
    }
}
