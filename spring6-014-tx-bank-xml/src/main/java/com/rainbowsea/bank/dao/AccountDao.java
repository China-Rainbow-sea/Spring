package com.rainbowsea.bank.dao;

import com.rainbowsea.bank.pojo.Account;

public interface AccountDao {

    /**
     * 根据账号查询账号信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);


    /**
     * 更新账号信息
     * @param account
     * @return
     */
    int update(Account account);


    /**
     * 保存账户信息
     * @param act
     * @return
     */
    int insert(Account act);
}
