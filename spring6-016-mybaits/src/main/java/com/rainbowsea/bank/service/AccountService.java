package com.rainbowsea.bank.service;

import com.rainbowsea.bank.pojo.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AccountService {
    /**
     * 开户
     * @param account
     * @return
     */
    int save(Account account);

    /**
     * 根据账号销户
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户
     * @param act
     * @return
     */
    int update(Account act);

    /**
     * 根据账号获取账户
     * @param actno
     * @return
     */
    Account getByActno(String actno);

    /**
     * 获取所有账户
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno, String toActno, double money);
}
