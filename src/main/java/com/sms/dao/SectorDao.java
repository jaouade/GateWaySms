package com.sms.dao;

import com.sms.entities.Sector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("sectordao")
public class SectorDao extends Dao<Sector> implements ISectorDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Sector get(Long id) {
        return (Sector) sessionFactory.getCurrentSession().get(Sector.class, id);

    }

    @Override
    public Sector save(Sector object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Sector object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Sector object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Sector> getAll() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Sector> ts = session.createCriteria(Sector.class).list();

        return ts;
    }

}
