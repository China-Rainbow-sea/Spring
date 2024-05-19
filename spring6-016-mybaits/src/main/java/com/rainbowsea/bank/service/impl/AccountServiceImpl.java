package com.rainbowsea.bank.service.impl;

import com.rainbowsea.bank.mapper.AccountMapper;
import com.rainbowsea.bank.pojo.Account;
import com.rainbowsea.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "accountServiceImpl")
@Transactional  // 放在类中，下面的类中的所有方法都开启了事务
public class AccountServiceImpl implements AccountService {

    // Could not find bean with name 'org.mybatis.spring.SqlSessionFactoryBean#0
    @Autowired // 非简单类型自动装配
    private AccountMapper accountMapper;
    @Override
    public int save(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int deleteByActno(String actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int update(Account act) {
        return accountMapper.update(act);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAct = accountMapper.selectByActno(fromActno);

        if(fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }

        Account toAct = accountMapper.selectByActno(toActno);

        //模拟异常
      /*  String s = null;
        s.toString();
*/
        // 内存上修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        // 数据库上修改数据内容
        int count = accountMapper.update(fromAct);
        count += accountMapper.update(toAct);

        if(count != 2) {
            throw new RuntimeException("转账失败");
        }


    }
}
