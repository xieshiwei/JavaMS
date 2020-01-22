package com.springboot.service.impl;

import com.springboot.entity.Account;
import com.springboot.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @ClassName AccountServiceImpl
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/22 10:49
 **/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {


    @Override
    public Account getAccount(Integer id) {
        return null;
    }

    @Override
    public void add(Account account) {

    }
}
