package com.sms.dao;

import com.sms.entities.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class AccountDao extends Dao<Account> implements IAccountDao {


    @Override
    public Account getAcountByLogin(String login) {
        Session session = currentSession();
        Query query = session.createQuery("from Account a where a.credential.login = :login ");
        query.setParameter("login", login);
        Account a = (Account) query.uniqueResult();
        return a;
    }

    @Override
    public List<Account> getSubs(Account account) {
        Session session = currentSession();

        Query q = session.createQuery("from Account a WHERE a.client.corp_name=:corp_name and a.credential.role =:role");
        q.setParameter("corp_name", account.getClient().getCorp_name());
        q.setParameter("role", "sub_account");
        @SuppressWarnings("unchecked")
        List<Account> subs = q.list();

        return subs;
    }

}
