package com.rainbowsea;

public class ReflectAnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射机制怎么读取注解
        Class<?> clazz = Class.forName("com.rainbowsea.User");
        // 判断类上面有没有这个注解
        if(clazz.isAnnotationPresent(Component.class)) {
            // 获取类上的注解
            Component annotation = clazz.getAnnotation(Component.class);
            // 访问注解属性
            System.out.println(annotation.value());
        }
    }
}
