package com.rainbowsea.Bean.myDate;


import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date 工厂模式
 * DateFactoryBean 这个工厂Bean 协助我们Spring 创建这个普通的Bean；Date
 */
public class DateFactor implements FactoryBean<Date> {

    // 这个 String字符串类型，作为我们Date类型，进行一个转换
    private String strDate;

    public DateFactor() {
    }

    public DateFactor(String strDate) {
        this.strDate = strDate;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Date getObject() throws Exception {
        // 通过 SimpleDateFormat 来自定义我们的 Date 的日期时间类型的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 通过在 spring.xml 对DateFactor类当中的  String strDate 属性进行赋值
        Date date = simpleDateFormat.parse(this.strDate); // 将字符串类型转换为 Date 日期时间类型
        return date;  // 转换后返回 Date 类型，进行一个赋值操作
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;  // 单例 false 多例
    }
}
