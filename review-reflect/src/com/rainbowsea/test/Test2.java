package com.rainbowsea.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test2 {
    /*
    需求：
    假设你现在以下信息:
    1.有这样一个类，类名叫做：com.powernode.reflect.User
    2.这个类符合javabean规范，属性私有化，对外提供公开的setter和getter方法。
    3.你还知道这个类当中有一个属性，属性的名字叫做 age
    4.并且你还知道age属性的类型是 int 类型
   请使用反射机制调用set()方法，给 User 对象的age 属性赋值
     */

    public static void main(String[] args) {
        String className = "com.rainbowsea.reflect.User";
        String propertyName = "age";


        try {
            // 通过 反射机制调用setAge(int) 方法
            // 获取到对应的类
            Class<?> clazz = Class.forName(className);
            // 获取对应的方法
            // 方法名: 这里我们知道set 方法格式为: setAge() set+属性名的首字母大小+后面属性名的小写字母
            String setMethodName = "set" + propertyName.toUpperCase().charAt(0)+ propertyName.substring(1);
            // 获取对应的方法名:
            // 我们知道的属性名就可以，根据属性名获取属性类型
            // 下面这里获取到的是一个完整的：private int com.rainbowsea.reflect.User.age 类型名
            Field field = clazz.getDeclaredField(propertyName);

            // field.getType() 获取到属性的类型，是个简单的类型 int
            Method declaredMethod = clazz.getDeclaredMethod(setMethodName, field.getType());
            //System.out.println(field.getType());

            // 准备对象
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            Object obj = declaredConstructor.newInstance();
            // 调用set()方法赋值， 没有返回值(调用 obj 的对象中的，declaredMethod()方法，参数是 30,没有返回值)
            declaredMethod.invoke(obj,30);

            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }





    }
}
