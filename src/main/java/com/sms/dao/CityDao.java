package com.sms.dao;

import com.sms.entities.City;
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
@Component("citydao")
public class CityDao extends Dao<City> implements ICityDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public City get(Long id) {
        return (City) sessionFactory.getCurrentSession().get(City.class, id);

    }

    @Override
    public City save(City object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(City object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(City object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<City> getAll() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<City> ts = session.createCriteria(City.class).list();
        return ts;
    }

    @Override
    public int deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM City");
        return query.executeUpdate();

    }

}
