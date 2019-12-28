package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.model.Account;
import com.spring.service.IAccountService;

import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/28 20:08
 **/
public class AccountServiceImpl implements IAccountService {

    /**
     * 数据持久层接口
     */
    private IAccountDao accountDao;

    /**
     * 查询结果
     * @return
     */
    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    /**
     * 插入账户信息
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }
}
