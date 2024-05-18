package com.rainbowsea.bank.service.impl;


import com.rainbowsea.bank.dao.AccountDao;
import com.rainbowsea.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service(value = "i2")  // 交给Spring 管理
public class IsolationService2 {


    @Resource(name = "accountDaoImpl") // 因为accountDaoImpl已经交给Spring管理了，@Resource复杂类型的set注入赋值
    private AccountDao accountDao;

    // 2号
    //负责insert
    @Transactional(noRollbackFor = NullPointerException.class)  // NullPointerException(空指针异常).class(可以设置其他异常)或者整个异常的子类异常，都不回滚，其他异常回滚
    public void save(Account account) throws NullPointerException {
        accountDao.insert(account);

        if (1 == 1) {
            throw new RuntimeException();
        }
    }

}

//
//

