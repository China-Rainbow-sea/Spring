package com.rainbowsea.bank.service.impl;

import com.rainbowsea.bank.dao.AccountDao;
import com.rainbowsea.bank.pojo.Account;
import com.rainbowsea.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "accountServiceImpl2")  // 给Spring 管理起来
public class AccountServiceImpl2 implements AccountService {


    @Resource(name = "accountDaoImpl") // accountDaoImpl 已经交给Spring 管理，所以这里可以直接用 @Resource 根据名称set注入
    private AccountDao accountDao;
    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)  // 事务注解
    public void save(Account account) {
        accountDao.insert(account);

        // 模拟异常
        //String s = null;
        //s.toString();

        // 事儿没有处理完，这个大括号当中的后续也许还有其他的DML语句。
    }
}
