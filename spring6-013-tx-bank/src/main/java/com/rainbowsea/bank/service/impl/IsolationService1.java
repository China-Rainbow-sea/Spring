package com.rainbowsea.bank.service.impl;

import com.rainbowsea.bank.dao.AccountDao;
import com.rainbowsea.bank.pojo.Account;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "i1")
public class IsolationService1 {

    @Resource(name = "accountDaoImpl") // 因为 accountDaoImpl 已经交给Spring 管理了，所以可以使用@Resource 进行非简单类型的赋值
    private AccountDao accountDao;


    // 1号
    // 负责查询
    // 当前事务可以读取到别的事务没有提交的数据
    //@Transactional(isolation = Isolation.READ_UNCOMMITTED)
    //  对方事务提交之后的数据，我才能读取到
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void getByActno(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息: " + actno);
    }
}
