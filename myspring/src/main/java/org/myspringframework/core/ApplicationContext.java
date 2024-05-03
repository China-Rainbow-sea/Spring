package org.myspringframework.core;


/**
 * mySpring 框架应用上下文接口
 */
public interface ApplicationContext {
    /**
     * 根据bean的名称获取对应的Bean对象
     * beanName myspring 配置文件中bean标签的id.
     * 对应的单例 bean对象
     */
    Object getBean(String beanName);
}
