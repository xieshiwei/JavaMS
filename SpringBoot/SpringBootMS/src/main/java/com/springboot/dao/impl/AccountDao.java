package com.springboot.dao.impl;

import com.springboot.entity.Account;
import com.springboot.service.IAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AccountDao
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/22 10:50
 **/
@Repository("accountDao")
public class AccountDao implements IAccountService {

    @Override
    public Account getAccount(Integer id) {
        System.out.println("getAccount");
        return new Account();
    }

    @Override
    public void add(Account account) {
        System.out.println("add");
    }
}
