package com.spring.dao.impl;


import com.spring.dao.IAccountDao;
import com.spring.model.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;


    /**
     * 查询所有记录
     *
     * @return
     */
    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 插入数据
     *
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money) value (?,?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


}
