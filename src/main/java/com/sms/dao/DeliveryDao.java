package com.sms.dao;

import com.sms.entities.Delivery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("deliverydao")
public class DeliveryDao extends Dao<Delivery> implements IDeliveryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Delivery get(Long id) {
        return (Delivery) sessionFactory.getCurrentSession().get(Delivery.class, id);

    }

    @Override
    public Delivery save(Delivery object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Delivery object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Delivery object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Delivery> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Delivery> ts = session.createCriteria(Delivery.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
