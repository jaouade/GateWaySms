package com.sms.dao;

import com.sms.entities.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("countrydao")
public class CountryDao extends Dao<Country> implements ICountryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Country get(Long id) {
        return (Country) sessionFactory.getCurrentSession().get(Country.class, id);

    }

    @Override
    public Country save(Country object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Country object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Country object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Country> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Country> ts = session.createCriteria(Country.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
