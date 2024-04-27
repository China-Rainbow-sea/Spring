package com.rainbowsea.simple.factory.test;

import com.rainbowsea.simple.factory.Weapon;
import com.rainbowsea.simple.factory.WeaponFactory;

public class Test {

    public static void main(String[] args) {
        /*
        需要坦克
        对于我客户端来说，坦克的生产细节，我不需要关心，我只需要向工厂索要即可
        简单工厂模式达到了什么呢？职责分离，客户都安不需要关心产品的生产细节
        客户端只负责消费，工厂类负责生产，一个负责生产，一个负责消费，生产者和消费者分离了
        这就是简单工厂模式的作用。
         */

        // 需要坦克
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();


        // 需要匕首
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();


        // 需要战斗机
        Weapon fighter = WeaponFactory.get("FIGHTER");
        fighter.attack();
    }
}
