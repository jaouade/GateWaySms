package com.sms.dao;

import com.sms.entities.Account;

import java.util.List;

public interface IAccountDao extends IDao<Account> {
    Account getAcountByLogin(String login);

    List<Account> getSubs(Account account);
}
