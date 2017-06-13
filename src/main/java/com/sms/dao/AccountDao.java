package com.sms.dao;

import com.sms.entities.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("accountdao")
public class AccountDao extends Dao<Account> implements IAccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Account get(Long id) {
        return (Account) sessionFactory.getCurrentSession().get(Account.class, id);

    }

    @Override
    public Account save(Account object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Account object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Account object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Account> getAll() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Account> ts = session.createCriteria(Account.class).list();

        return ts;
    }

    @Override
    public Account getAcountByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Account a where a.credential.login = :login ");
        query.setParameter("login", login);
        Account a = (Account) query.uniqueResult();
        return a;
    }

    @Override
    public List<Account> getSubs(Account account) {
        Session session = sessionFactory.getCurrentSession();

        Query q = session.createQuery("from Account a WHERE a.client.corp_name=:corp_name and a.credential.role =:role");
        q.setParameter("corp_name", account.getClient().getCorp_name());
        q.setParameter("role", "sub_account");
        @SuppressWarnings("unchecked")
        List<Account> subs = q.list();

        return subs;
    }

}
