package com.rainbowsea.spring6.text;

import com.rainbowsea.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringJdbcTest {

    /**
     * 回调函数
     * 如果你想写JDBC代码，可以使用callback回调函数
     */
    @Test
    public void testCallback() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 准备 sql语句
        String sql = "select id,real_name,age from user where id = ?";
        // 注册回调函数，当execute 方法执行的时候，回调函数中的doInPreparedStatement()会被调用
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {

            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                // 第一个占位符，? 为 2
                ps.setInt(1,2);
                ResultSet resultSet = ps.executeQuery();
                if(resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String realName = resultSet.getString("real_name");
                    int age = resultSet.getInt("age");

                    user = new User(id,realName,age);
                }

                return user;
            }
        });

        System.out.println(user);


    }

    /**
     * 批量删除数据
     */
    @Test
    public void testBatchDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from user where id = ?";

        // 准备数据
        Object[] objects1 = {11};
        Object[] objects2 = {12};
        Object[] objects3 = {13};
        Object[] objects4 = {14};

        // 添加到List 集合
        List<Object[]> list = new ArrayList<>();

        list.add(objects1);
        list.add(objects2);
        list.add(objects3);
        list.add(objects4);

        // 执行SQL语句
        int[] counts = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(counts));

    }


    /**
     * 批量添加
     */
    @Test
    public void testBatchInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "insert into user(real_name,age) values(?,?)";

        // 准备数组(用于添加的数据)
        Object[] objs1 = {"小华1",20};
        Object[] objs2 = {"小华2",21};
        Object[] objs3 = {"小华3",22};
        Object[] objs4 = {"小华4",23};

        // 添加到List 集合,注意这里添加的是 Object[] 数组的
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);
        list.add(objs4);


        // 执行SQL语句,返回修改的行数
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    /**
     * 查询多个值
     */
    @Test
    public void testQueryOneValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(1) from user"; // 返回总记录条数是一个整数数字
        // 注意：因为我们要返回的是一个值，是个数值，不是对应的 User 表的反映的bena 了
        Integer count = jdbcTemplate.queryForObject(sql, int.class);
        Long count2 = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
        System.out.println(count2);


    }


    /**
     * 查询多个对象
     */
    @Test

    public void testQueryAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "select id, real_name, age from user";
        // 返回的是一个数组
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);


    }


    /**
     * 根据 id ，查询一条记录
     */
    @Test
    public void testQueryOne() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "select id, real_name,age from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    /**
     * 根据id ，删除内容
     */
    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "delete from user where id = ?";
        int count = jdbcTemplate.update(sql, 4);
        System.out.println(count);
    }


    /**
     * 修改数据
     */
    @Test
    public void testUpdate() {
        // 根据 id 来修改是某一条记录
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "update user set real_name = ?, age = ? where id = ?";
        int count = jdbcTemplate.update(sql, "张三丰", 55, 1);
        System.out.println(count);

    }

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
        // 注意: 在JdbcTemplate当中，只要是insert delete update 语句的（增删改），都是调用update方法
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
