package com.rainbowsea.bank;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration // 代替sprint.xml 配置文件，在这个类当中完成配置
@ComponentScan("com.rainbowsea.bank")  // 组件扫描
@EnableTransactionManagement // 开启事务
public class Spring6Config {


    // 设置数据源信息配置
    /*
    Spring 框架，看到这个@Bean注解后，会调用这个被标注的方法，这个方法的返回值式一个Java对象，
    这个Java对象会自动纳入IOC容器管理，返回的对象就是Spring容器当中的一个Bean了
    并且这个Bean的名字式：dataSource
     */
    @Bean(name = "dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring6");
        dataSource.setUsername("root");
        dataSource.setPassword("MySQL123");

        // 设置好后，返回给Spring 管理
        return dataSource;
    }


    @Bean(name = "jdbcTemplate")
    // Spring 在调用这个方法的时候会自动给我们传递过来一个dataSource 对象。
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.setDataSource(getDataSource());  // 一般是直接调用上面那个

        // 设置好后，返回给Spring 管理
        return jdbcTemplate;
    }

    @Bean(name = "txManager")
    // 事务上的管理
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);

        // 设置好后，返回给Spring 管理
        return dataSourceTransactionManager;
    }

}
