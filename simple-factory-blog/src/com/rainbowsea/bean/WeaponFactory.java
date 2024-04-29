package com.rainbowsea.bean;


/**
 * 抽象工厂类角色：
 * 根据不同的武器类型生产武器
 */
public class WeaponFactory {

    /*
    静态方法，要获取什么产品，就看你传什么参数，传Tank获取坦克，传Dagger获取匕首，
    简单工厂模式中有一个静态方法，所以被称为：静态工厂方法模式。
     */
    public static Weapon get(String type) {

        // 参数不对，返回 null
        if (null == type || type.length() == 0) {
            return null;
        }

        // 要匕首产品，给匕首
        if ("DAGGER".equals(type)) {
            return new Dagger();
        } else if ("TANK".equals(type)) {  // 要坦克给产品，给坦克
            return new Tank();
        } else {
            throw new RuntimeException("暂时不支持该武器的生产制造");
        }

    }
}
