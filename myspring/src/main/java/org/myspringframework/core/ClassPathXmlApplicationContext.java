package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClassPathXmlApplicationContext implements ApplicationContext {


    // 解析myspring.xml文件，然后实例化Bean，将Bean存放到singletonObjects集合当中
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析myspring的配置文件，然后初始化所有的Bean对象
     *
     * @param configLocation spring配置文件的路径，注意：使用的是ClassPathXmlApplicationContext ,所以
     *                       配置文件应当放到类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        // 解析myspring.xml文件，然后实例化Bean，将Bean存放到singletonObjects集合当中
        // 这是dom4j 解析xml 文件的核心对象
        SAXReader saxReader = new SAXReader();
        Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);


        // 获取一个输入流，指向配置文件
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
        try {
            // 读文件
            Document document = saxReader.read(in);

            // 获取到所有的 <bean>标签
            // 注意要两个//，才能表示一个 /
            List<Node> nodes = document.selectNodes("//bean");

            // 遍历 bean标签
            nodes.forEach(node -> {
                //System.out.println(node);
                // 向下转型的目的是为了使用Element接口更加丰富的方法
                Element beanElt = (Element) node;

                // 获取 <bean>标签当中的id的属性
                String id = beanElt.attributeValue("id");

                // 获取 <bean>标签当中的 class 属性
                String className = beanElt.attributeValue("class");
                //logger.info("beanName" + id);
                //logger.info("beanClassName " + className);

                try {
                    // 通过反射机制创建对象，将其放到Map集合中，提前曝光
                    // 获取class对象
                    Class<?> aClass = Class.forName(className);
                    // 获取无参构造方法实例化Bean
                    Constructor<?> declaredCon = aClass.getDeclaredConstructor();
                    // 调用无参构造方法实例化Bean
                    Object bean = declaredCon.newInstance();
                    // 将Bean 曝光，加入 Map集合
                    singletonObjects.put(id, bean);
                    // 记录日志
                    //logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }


            });

            // 再次重新把所有的 Bean 标签遍历一次，这一次主要是给对象属性赋值的
            nodes.forEach(node -> {
                Element beanElt = (Element) node;
                // 获取 <bean>标签当中的 id 属性
                String id = beanElt.attributeValue("id");

                // 获取<bean>标签当中的 class 属性的值
                String className = beanElt.attributeValue("class");

                // 获取Class 对象通过全限定类名+反射机制


                try {
                    Class<?> aClass = Class.forName(className);
                    // 获取该<bean>标签下的所有的属性为 <property>标签
                    List<Element> propertys = beanElt.elements("property");
                    // 遍历<property> 的所有的属性标签
                    propertys.forEach(property -> {
                        // 获取 <property> 标签下的name 属性名下的值
                        String propertyName = property.attributeValue("name");
                        //logger.info(" <property> 标签下的name 属性名 " + propertyName);
                        // 获取 <property> 标签下的name 属性名下的值

                        // 获取 set 方法名 set+属性名第一个单词大写
                        String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);

                        try {
                            //获取 set 方法
                            // 获取属性类型，通过属性名，可以获取到属性类型
                            Field declaredField = aClass.getDeclaredField(propertyName);
                            // 获取set方法
                            Method setMethod = aClass.getDeclaredMethod(setMethodName, declaredField.getType());
                            // 调用set方法(set方法没有返回值)

                            // 获取 <property> 标签当中的 value 或者是 ref 的具体的值
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");

                            Object actualValue = null; // 真值
                            if (value != null) {
                                // 说明在<property> 标签当中  这个值是简单类型
                                /*
                                我们myspring框架说明以下，我们只支持这些类型为简单类型
                                byte short int long float double boolean char
                                Byte Short Intger Long Float Double Boolean Character
                                String
                                 */
                                // 获取属性类型名
                                String propertyTypeSimpleName = declaredField.getType().getSimpleName();
                                switch (propertyTypeSimpleName) {
                                    case "byte":
                                        actualValue = Byte.parseByte(value);
                                        break;
                                    case "short":
                                        actualValue = Short.parseShort(value);
                                        break;
                                    case "int":
                                        actualValue = Integer.parseInt(value);
                                        break;
                                    case "long":
                                        actualValue = Long.parseLong(value);
                                        break;
                                    case "float":
                                        actualValue = Float.parseFloat(value);
                                        break;
                                    case "double":
                                        actualValue = Double.parseDouble(value);
                                        break;
                                    case "boolean":
                                        actualValue = Boolean.parseBoolean(value);
                                        break;
                                    case "char":
                                        actualValue = value.charAt(0);
                                        break;
                                    case "Byte":
                                        actualValue = Byte.valueOf(value);
                                        break;
                                    case "Short":
                                        actualValue = Short.valueOf(value);
                                        break;
                                    case "Integer":
                                        actualValue = Integer.valueOf(value);
                                        break;
                                    case "Long":
                                        actualValue = Long.valueOf(value);
                                        break;
                                    case "Float":
                                        actualValue = Float.valueOf(value);
                                        break;
                                    case "Double":
                                        actualValue = Double.valueOf(value);
                                        break;
                                    case "Boolean":
                                        actualValue = Boolean.valueOf(value);
                                        break;
                                    case "Character":
                                        // char 仅仅只是一个字符，所以要获取第一个字符
                                        actualValue = value.charAt(0);
                                        break;
                                    case "String":
                                        actualValue = value;
                                        break;


                                }
                                setMethod.invoke(singletonObjects.get(id), actualValue);
                            }

                            if (ref != null) {
                                // 说明这个值是非简单类型
                                // 因为是非简单类型，那么它提前曝光的，就存放到了集合当前去了。
                                setMethod.invoke(singletonObjects.get(id), singletonObjects.get(ref));

                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            });


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
