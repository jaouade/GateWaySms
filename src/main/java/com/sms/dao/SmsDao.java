package com.sms.dao;

import com.sms.entities.Sms;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("smsdao")
public class SmsDao extends Dao<Sms> implements ISmsDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Sms get(Long id) {
        return (Sms) sessionFactory.getCurrentSession().get(Sms.class, id);

    }

    @Override
    public Sms save(Sms object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Sms object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Sms object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Sms> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Sms> ts = session.createCriteria(Sms.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
