package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @ClassName AccountServiceImpl
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/30 13:55
 **/
@Service("accountService")
@Scope(value = "prototype")
public class AccountServiceImpl implements IAccountService {

    /**
     * 自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
     */
    @Autowired
    @Qualifier("accountDao")
    private IAccountDao accountDao2 = null;

    public void saveAccount() {
        accountDao2.saveAccount();
    }
}
