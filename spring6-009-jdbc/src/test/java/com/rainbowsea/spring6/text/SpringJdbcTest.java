package com.rainbowsea.spring6.text;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJdbcTest {


    /**
     * 插入添加数据
     */
    @Test
    public void testInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);

        // insert 语句
        String sql = "insert into user(real_name,age) values(?,?)";
        // 注意: 在JdbcTemplate当中，只要是insert delete update 语句的，都是调用update方法
        int count = jdbcTemplate.update(sql, "李华", 21);
        System.out.println(count);


    }

    @Test
    public void testJdbc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);

    }
}
