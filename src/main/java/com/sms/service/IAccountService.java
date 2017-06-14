package com.sms.service;

import com.sms.entities.Account;

import java.util.List;

public interface IAccountService extends Iservice<Account> {
    Account getAcountByLogin(String login);

    List<Account> getSubs(Account account);
}
