package com.sms.dao;

import com.sms.entities.Account;
import com.sms.entities.PhoneBook;
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
@Component("phonebookdao")
public class PhoneBookDao extends Dao<PhoneBook> implements IPhoneBookDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PhoneBook get(Long id) {
        return (PhoneBook) sessionFactory.getCurrentSession().get(PhoneBook.class, id);

    }

    @Override
    public PhoneBook save(PhoneBook object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(PhoneBook object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(PhoneBook object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<PhoneBook> getAll() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<PhoneBook> ts = session.createCriteria(PhoneBook.class).list();
        return ts;
    }

    @Override
    public List<PhoneBook> getAllByAccount(Account acc) {
        Session session = sessionFactory.getCurrentSession();

        Query q = session.createQuery("from PhoneBook p WHERE p.account.idAccount=:id");
        q.setParameter("id", acc.getIdAccount());
        @SuppressWarnings("unchecked")
        List<PhoneBook> phbs = q.list();

        return phbs;
    }

}
