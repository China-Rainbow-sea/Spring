package com.rainbowsea.spring6.bean;


/**
 * user 数据表对应的映射的 bean 对象
 */
public class User {


    // 定义包装类，作为属性类型，防止 数据库中的数值为 null，报错
    private Integer id;
    private String realName;
    private Integer age;

    public User(Integer id, String realName, Integer age) {
        this.id = id;
        this.realName = realName;
        this.age = age;
    }


    public User() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                '}';
    }
}
