package com.rainbowsea.spring6.bean;

public class User {

    private String name;

    public User() {
        System.out.println("第一步: 无参构造方法执行");
    }

    public User(String name) {

        this.name = name;
    }


    /**
     * 这个方法需要自己写，方法名随意，但是注意写好之后，要配给Spring框架，让其知道这个东东
     */
    public void initBean() {
        System.out.println("第三步: 初始化Bean.");
    }

    /**
     * 这个方法需要自己写，方法名随意，但是注意写好之后，要配给Spring框架，让其知道这个东东
     */
    public void destroyBean() {
        System.out.println("第五步: 销毁Bean");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("第二步: 给对象的属性赋值");
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
