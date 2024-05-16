package com.rainbowsea.bank.dao.impl;

import com.rainbowsea.bank.dao.AccountDao;
import com.rainbowsea.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository(value = "accountDaoImpl")  // 交给 spring 管理
public class AccountDaoImpl implements AccountDao {




    @Resource(name = "jdbcTemplate")  // jdbcTemplate 内置的对象，resource 根据名称进行 set 注入赋值
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
