package com.rainbowsea.spring6.bean.Date;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Date 工厂模式
 * DateFactoryBean 这个工厂Bean 协助我们Spring 创建这个普通的Bean；Date
 */
public class DateFactorBean implements FactoryBean<Date> {


    private String strDate;

    public DateFactorBean() {

    }

    public DateFactorBean(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(this.strDate);
        return date;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
