package com.rainbowsea;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {

    /*
    目前只知道一个包的名字，扫描这个包下所有的类，当这个类上有@Compoent 注解的时候，
    实例化该对象，然后放到Map集合中
     */
    public static void main(String[] args) {

        //定义一个集合存储其中的实例化对象
        Map<String,Object> beanMap = new HashMap<>();

        String packageName = "com.rainbowsea";
        // 开始扫描程序
        // .这个正则表达式表示任意字母，这里的“.” 必须是一个普通的"."字符，不能是正则表达式中的“.”
        // 在正则表达式当中怎么表示一个普通的"." 字符呢？使用"\",在Java当中一个“/” 要用两个“//” 表示
        String packagePath = packageName.replaceAll("\\.", "/");

        //System.out.println(packagePath);
        // com 是在类的根路径下的一个目录
        //  url 是一个绝对路径
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();
        //System.out.println(path);

        // 获取一个绝对路径下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();

        Arrays.stream(files).forEach(file1 -> {
            //System.out.println(file1);
            //System.out.println(file1.getName().split("\\.")[0]);
            // 拼接成：全限定类名
            String className = packageName + "." + file1.getName().split("\\.")[0];
            // 再通过反射机制，解析注解
            Class<?> aClass = null;
            try {
                aClass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // 判断该类是否含有该 Component.class 注解
            if(aClass.isAnnotationPresent(Component.class)) {
                // 获取注解
                Component annotation = aClass.getAnnotation(Component.class);
                // 获取到该注解的值
                String id = annotation.value();
                // 有这个注解的都要创建对象
                try {
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                    Object obj  = declaredConstructor.newInstance();
                    // 将创建好的实例化对象存储到 Map 当前去。
                    beanMap.put(id,obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

        });


        System.out.println(beanMap);
    }
}
