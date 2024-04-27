package com.rainbowsea.spring6.bean;

import org.springframework.beans.factory.FactoryBean;


/**
 * 第四种：获取Bean
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {

        // 同样的：最终这个 对应的Bean的创建还是程序员自己 new 出来的。
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /**
     * 这个方法在接口中有默认实现
     * 默认返回 true，表示单例的
     * 如果想多例的化，直接讲这个修改为： return false 即可。
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
