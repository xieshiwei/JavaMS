package com.spring.test;

import com.spring.model.Account;
import com.spring.service.IAccountService;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName AccountServiceTest
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/28 20:11
 **/
public class AccountServiceTest {


    private IAccountService service = null;

    @Test
    public void testFindAll() {
        List<Account> accounts = service.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account.getName());
        }
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setMoney(10f);
        account.setName("xdescribe");
        service.saveAccount(account);
    }


}
