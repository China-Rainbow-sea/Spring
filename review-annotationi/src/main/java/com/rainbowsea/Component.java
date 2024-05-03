package com.rainbowsea;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 标注注解的注解，叫做元注解，@Target 注解用来修饰@Compent 可以出现的位置
//@Target(value = {ElementType.TYPE,ElementType.FIELD})
// 以下表示@componet注解可以出现在类上
//@Target(value = {ElementType.TYPE})
// 使用某个注解的时候，如果注解的属性名是 value 的话，value 可以省略
//@Target({ElementType.TYPE})
// 使用某个注解的时候，如果注解的属性值是数组，并且数组中只有一个元素，大括号可以省略。
@Target(ElementType.TYPE)
// @Retention 也是一个元注解，用来标注@Component 注解最终保留在class 文件当中，并且可以被反射机制读取
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    // 定义注解的属性
    // String 是属性类型
    // value 是属性名
    String value();



    // 其他的属性
    // 属性类型String
    // 属性名是name
    //String name();


    // 数组属性
    //属性类型是: String[]
    //// 属性名: names
    //String[] names();
    //int[] ages();
    //
    //int age();
}
