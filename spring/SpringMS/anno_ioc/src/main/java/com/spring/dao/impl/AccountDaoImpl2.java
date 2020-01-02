package com.spring.dao.Impl;

import com.spring.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AccountDaoImpl2
 * <p>
 * 账户的持久层实现类
 * <p>
 * Repository 的作用就和在XML配置文件中编写一个<bean>标签实现的功能是一样的
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/30 14:04
 **/
@Repository("account222")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存账户2222222222222");
    }
}