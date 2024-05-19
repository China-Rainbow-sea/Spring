package com.rainbowsea.bank.mapper;

import com.rainbowsea.bank.pojo.Account;

import java.util.List;

// 该接口的实现类不需要写，是mybatis通过动态代理机制生成的实现类
public interface AccountMapper {

    // 这就是DAO，只要编写CRUD方法即可

    /**
     * 新增账户
     * @param account
     * @return
     */
    int insert(Account account);


    /**
     * 根据账户删除账户
     * @param actno
     * @return
     */
    int deleteByActno(String actno);


    /**
     * 根据账户更新
     * @param account
     * @return
     */
    int update(Account account);


    /**
     * 根据账户查询账户
     * @param actno
     * @return
     */
    Account selectByActno(String actno);


    /**
     * 查询所有的账户
     * @return
     */
    List<Account> selectAll();

}
