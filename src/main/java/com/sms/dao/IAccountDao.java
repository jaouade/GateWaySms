package com.sms.dao;

import com.sms.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAccountDao extends IDao<Account> {
    Account getAcountByLogin(String login);

    List<Account> getSubs(Account account);
}
