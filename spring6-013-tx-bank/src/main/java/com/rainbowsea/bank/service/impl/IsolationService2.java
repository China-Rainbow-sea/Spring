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
    //  @Transactional(timeout = 10)设置事务超时间为 10
    //@Transactional(timeout = 10)  // 事务
    //@Transactional(rollbackFor = RuntimeException.class)  // 只要发生RuntimeException.class(可以设置其他异常)
    // 或者整个异常的子类异常，都回滚，其他异常回滚
    @Transactional(noRollbackFor = NullPointerException.class)  // NullPointerException(空指针异常).class(可以设置其他异常)
    // 或者整个异常的子类异常，都不回滚，其他异常回滚
    public void save(Account account) throws IOException {
        accountDao.insert(account);

        // 睡眠一会
       /* try {
            Thread.sleep(1000 * 12);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/


        if(1 == 1) {
            //throw new IOException();
            throw new RuntimeException();
            //throw new NullPointerException();
        }
        //accountDao.insert(account);
        // 当然，如果想让整个方法的所有代码都计入超时时间的话，可以在方法最后一行添加一行无关紧要的DML语句
        // if() 1= 1 恒为真的一个简单判断。
    }


}
