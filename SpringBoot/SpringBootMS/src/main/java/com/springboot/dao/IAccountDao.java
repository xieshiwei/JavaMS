package com.springboot.dao;

import com.springboot.entity.Account;

/**
 * @ClassName IAccountDao
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/22 10:50
 **/
public interface IAccountDao {

    Account getAccount(Integer id);

    void add(Account account);
}
