package com.spring.dao;

import com.spring.model.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    /**
     * 查询用户
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 保存用户
     */
    void saveAccount(Account account);

}
