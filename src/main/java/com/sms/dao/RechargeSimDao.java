package com.sms.dao;

import com.sms.entities.RechargeSim;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("rechargesimdao")
public class RechargeSimDao extends Dao<RechargeSim> implements IRechargeSimDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public RechargeSim get(Long id) {
        return (RechargeSim) sessionFactory.getCurrentSession().get(RechargeSim.class, id);

    }

    @Override
    public RechargeSim save(RechargeSim object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(RechargeSim object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(RechargeSim object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<RechargeSim> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<RechargeSim> ts = session.createCriteria(RechargeSim.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
