package com.sms.dao;

import com.sms.entities.Compagne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("compagnedao")
public class CompagneDao extends Dao<Compagne> implements ICompagneDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Compagne get(Long id) {
        return (Compagne) sessionFactory.getCurrentSession().get(Compagne.class, id);

    }

    @Override
    public Compagne save(Compagne object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Compagne object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Compagne object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Compagne> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Compagne> ts = session.createCriteria(Compagne.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
