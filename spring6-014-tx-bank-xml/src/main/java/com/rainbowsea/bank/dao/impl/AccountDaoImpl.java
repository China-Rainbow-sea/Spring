package com.rainbowsea.bank.dao.impl;

import com.rainbowsea.bank.dao.AccountDao;
import com.rainbowsea.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component(value = "accountDaoImpl")
public class AccountDaoImpl implements AccountDao {


    @Resource(name = "jdbcTemplate")  // 该jdbcTemplate 已经纳入了Spring ICO 容器当中管理了，可以用@Resource根据
    // 名称进行 非简单类型的 set 注入赋值
    private JdbcTemplate jdbcTemplate;


    @Override
    public Account selectByActno(String actno) {

        String sql = "select actno,balance from t_act where actno = ?";

        // 查询
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);

        return account;
    }

    @Override
    public int update(Account account) {
        String sql = "update t_act set balance = ? where actno = ?";
        int count = jdbcTemplate.update(sql, account.getBalance(), account.getActno());
        return count;
    }

    @Override
    public int insert(Account act) {
        String sql = "insert into t_act(balance,actno) values(?,?)";
        int count = jdbcTemplate.update(sql,  act.getBalance(),act.getActno());
        return count;
    }
}
