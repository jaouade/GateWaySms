package com.sms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class Dao<T> implements IDao<T> {

    private Class<T> clazz;
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public T get(Long id) {
        return (T) sessionFactory.getCurrentSession().get(getClazz(), id);

    }

    @Override
    public T save(T object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(T object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(T object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<T> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<T> ts = session.createCriteria(getClazz()).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }


    private Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }


}
