package com.sms.dao;

import com.sms.entities.PhoneNumber;
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
@Component("phonenumberdao")
public class PhoneNumberDao extends Dao<PhoneNumber> implements IPhoneNumberDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PhoneNumber get(Long id) {
        return (PhoneNumber) sessionFactory.getCurrentSession().get(PhoneNumber.class, id);

    }

    @Override
    public PhoneNumber save(PhoneNumber object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(PhoneNumber object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(PhoneNumber object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<PhoneNumber> getAll() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<PhoneNumber> ts = session.createCriteria(PhoneNumber.class).list();

        return ts;
    }

    @Override
    public List<PhoneNumber> getAllByPhoneBook(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from PhoneNumber p WHERE p.phoneBook.idPhoneBook=:id");
        q.setParameter("id", id);
        @SuppressWarnings("unchecked")
        List<PhoneNumber> smstps = q.list();
        return smstps;
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumberByPhoneBookAndAccount(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from PhoneNumber p WHERE p.phoneBook.account.idAccount=:id");
        q.setParameter("id", id);
        @SuppressWarnings("unchecked")
        List<PhoneNumber> smstps = q.list();
        return smstps;
    }

}
