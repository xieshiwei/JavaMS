package com.spring.service;

import com.spring.model.Account;

import java.util.List;

public interface IAccountService {
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
