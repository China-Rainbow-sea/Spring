package com.rainbowsea.test;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    // 反射调用一个有参数的方法()
    public static void main(String[] args) {
        Object retValue = null;
        try {
            // 获取类
            Class<?> clazz = Class.forName("com.rainbowsea.reflect.SomeService");

            // 获取方法（因为方法可以重载，所以要通过参数，指定对应的方法）
            Method dosomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);

            // 调用方法
            // 四要素：调用哪个对象，哪个方法，传什么参数，返回什么值
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            Object obj = declaredConstructor.newInstance();
            retValue = dosomeMethod.invoke(obj, "张三", 90);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
        System.out.println(retValue);
    }


    public static void main1(String[] args) {
        try {
            // 使用反射机制怎么调用方法
            // 获取类
            Class<?> clazz = Class.forName("com.rainbowsea.reflect.SomeService");

            // 获取方法
            Method doSome = clazz.getDeclaredMethod("doSome");


            // 调用方法
            // 四要素：调用哪个对象，哪个方法，传什么参数，返回什么值
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            Object obj = declaredConstructor.newInstance();
            doSome.invoke(obj);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
