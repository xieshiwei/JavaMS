package com.springboot.service;

import com.springboot.entity.Account;

public interface IAccountService {
    Account getAccount(Integer id);

    void add(Account account);
}
