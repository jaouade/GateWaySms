package com.sms.service;

import com.sms.dao.AccountDao;
import com.sms.dao.IDao;
import com.sms.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@org.springframework.stereotype.Service
public class AccountService extends Service<Account> implements IAccountService {
        private AccountDao accountDao;
    public AccountService(){

    }
    @Autowired
    public AccountService(
            @Qualifier("accountDao") IDao<Account> genericDao) {
        super(genericDao);
        this.accountDao = (AccountDao) genericDao;
    }

    @Override
    public Account getAcountByLogin(String login) {
        return accountDao.getAcountByLogin(login);
    }

    @Override
    public List<Account> getSubs(Account account) {
        return accountDao.getSubs(account);
    }
}
