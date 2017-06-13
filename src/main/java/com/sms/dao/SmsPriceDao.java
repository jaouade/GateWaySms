package com.sms.dao;

import com.sms.entities.SmsPrice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("smspricedao")
public class SmsPriceDao extends Dao<SmsPrice> implements ISmsPriceDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public SmsPrice get(Long id) {
        return (SmsPrice) sessionFactory.getCurrentSession().get(SmsPrice.class, id);

    }

    @Override
    public SmsPrice save(SmsPrice object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(SmsPrice object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(SmsPrice object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<SmsPrice> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<SmsPrice> ts = session.createCriteria(SmsPrice.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
