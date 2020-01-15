package com.spring.dao;

public interface Account {

    /**
     * 根据ID查询账户
     *
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);


}
