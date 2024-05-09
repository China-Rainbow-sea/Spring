package com.rainbowsea.test;

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

public class JdbcTest {


    /**
     * 回调函数
     * 如果你想写JDBC代码，可以使用callback回调函数
     */
    @Test
    public void testCallback() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 准备 sql语句
        String sql = "select id,real_name,age from user2 where id = ?";

        // 注册回调函数，当execute 方法执行的时候，回调函数中的doInPreparedStatement()会被调用
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {

            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                // 1 表示第一个占位符，?的下标， 为 2
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
     * 批量删除
     */
    @Test
    public void testDeleteBatch() {
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        // 批量删除
        String sql = "delete from user2 where id = ?";
        Object[] objs1 = {5};
        Object[] objs2 = {6};
        Object[] objs3 = {7};

        // 将要修改的数据封装到 List 集合当中，再作为参数传入
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }


    /**
     * 批量修改
     */
    @Test
    public void testUpdateBatch() {
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 批量修改
        String sql = "update user2 set age = ? where id = ?";
        Object[] objs1 = {10, 5};
        Object[] objs2 = {11, 6};
        Object[] objs3 = {12, 7};

        // 将要修改的数据封装到 List 集合当中，再作为参数传入
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }


    /**
     * 批量添加数据
     */
    @Test
    public void testAddBatch() {
// 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 批量添加，id 是自增的，这里可以省略
        String sql = "insert into user2(real_name,age) values(?,?)";

        Object[] objs1 = {"小花", 20};
        Object[] objs2 = {"小明", 21};
        Object[] objs3 = {"小刚", 22};


        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    /**
     * 查询数据表中的一个值
     */
    @Test
    public void testSelectOneValue() {
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行插入操作
        // 编写SQL语句，? 表示占位符
        // 执行select
        String sql = "select count(1) from user2";
        // 返回对应数据类型的包装类
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    /**
     * 查询多条记录
     */
    @Test
    public void testSelectAll() {
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行插入操作
        // 编写SQL语句，? 表示占位符
        // 执行select
        String sql = "select id, real_name, age from user2";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);

    }


    /**
     * 查询一条记录
     */
    @Test
    public void testSelectOne() {
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行插入操作
        // 编写SQL语句，? 表示占位符
        String sql = "select id, real_name, age from user2 where id = ?";
        // 执行更新操作
        // 返回对应查询到的 Bean 类
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    public void testDelete() {
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行插入操作
        // 编写SQL语句，? 表示占位符
        String sql = "delete from user2 where id = ?";
        // 执行更新操作
        // 注意：insert delete update的sql语句，都是执行update方法。
        // 返回修改的记录条数
        int count = jdbcTemplate.update(sql, 4);
        System.out.println("插入的记录条数：" + count);
    }


    @Test
    public void testUpdate() {
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行插入操作
        // 注意：insert delete update的sql语句，都是执行update方法。,? 表示占位符
        // 执行更新操作
        String sql = "update user2 set real_name = ?, age = ? where id = ?";
        int count = jdbcTemplate.update(sql, "张小六", 18, 1);
        System.out.println(count);
    }

    @Test
    public void testInsert() {
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行插入操作
        // 注意：insert delete update的sql语句，都是执行update方法。,? 表示占位符
        // 因为 id 是自增的，所以，这里我们不赋值

        String sql = "insert into user2(real_name,age) values(?,?)";
        // 返回修改的记录条数
        int count = jdbcTemplate.update(sql, "张三", 30);
        System.out.println("插入的记录条数：" + count);
    }
}
