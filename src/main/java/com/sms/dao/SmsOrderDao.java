package com.sms.dao;

import com.sms.entities.SmsOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("smsorderdao")
public class SmsOrderDao extends Dao<SmsOrder> implements ISmsOrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SmsOrder get(Long id) {
        return (SmsOrder) sessionFactory.getCurrentSession().get(SmsOrder.class, id);

    }

    @Override
    public SmsOrder save(SmsOrder object) {
        sessionFactory.getCurrentSession().save(object);
        return object;

    }

    @Override
    public void update(SmsOrder object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(SmsOrder object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<SmsOrder> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<SmsOrder> ts = session.createCriteria(SmsOrder.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
