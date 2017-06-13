package com.sms.dao;

import com.sms.entities.SimCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("simcarddao")
public class SimCardDao extends Dao<SimCard> implements ISimCardDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SimCard get(Long id) {
        return (SimCard) sessionFactory.getCurrentSession().get(SimCard.class, id);

    }

    @Override
    public SimCard save(SimCard object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(SimCard object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(SimCard object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<SimCard> getAll() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<SimCard> ts = session.createCriteria(SimCard.class).list();
        for (SimCard simCard : ts) {
            System.out.println(simCard.getSimNumber());
        }
        return ts;
    }

}
