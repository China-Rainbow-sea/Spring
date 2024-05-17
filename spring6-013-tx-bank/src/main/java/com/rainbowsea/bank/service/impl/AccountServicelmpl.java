package com.rainbowsea.bank.service.impl;

import com.rainbowsea.bank.dao.AccountDao;
import com.rainbowsea.bank.pojo.Account;
import com.rainbowsea.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component(value = "AccountServicelmpl")
public class AccountServicelmpl implements AccountService {


    @Resource(name = "accountDaoImpl")  // @Resource 根据名称进行set 注入赋值
    private AccountDao accountDao;

    @Resource(name = "accountServiceImpl2")
    private AccountService accountService2;


    // 控制事务: 因为在这个方法中要完成所有的转账业务
    @Override
    //@Transactional(isolation = Isolation.READ_COMMITTED)  // 开启事务
    public void transfer(String fromActno, String toActno, double money) {

        // 第一步：开启事务

        // 第二步：执行核心业务逻辑

        // 查询转出账号的余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);

        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足，转账失败");
            // 第三步：回滚事务
        }

        // 余额充足
        Account toAct = accountDao.selectByActno(toActno);

        // 将内存中两个对象的余额先修改一下
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);


        // 数据库更新
        int count = accountDao.update(fromAct);

        // 模拟异常
        String s = null;
        s.toString();

        count += accountDao.update(toAct);

        if (count != 2) {
            throw new RuntimeException("转账失败，联系银行");
            // 第三步回滚事务
        }

        // 第三步：如果执行业务流程过程中，没有异常，提交事务
        // 第四五：如果执行业务流程过程中，有异常，回滚事务

    }

    /**
     * 保护账号信息
     *
     * @param account
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account account) {

        // 这里调用的dao的 insert ()方法，插入记录
        accountDao.insert(account);  // 保存 act-003 账户信息

        // 创建账号对象
        Account act2 = new Account("act-004", 1000.0);
        // 这里调用 accountServiceImpl2 中的 save() 方法进行插入
        try {
            accountService2.save(act2);
        } catch (Exception e) {

        }

        // 继续往后进行我当前1号事务自己的事儿。

    }


}
