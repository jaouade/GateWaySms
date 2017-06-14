package com.sms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
@Repository
@SuppressWarnings("unchecked")
public abstract class Dao<T> implements IDao<T> {

    private Class<T> clazz;
    @Autowired
    private SessionFactory sessionFactory;

    public Dao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;

        clazz = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

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
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(getClazz()).list();
    }


    @Contract(pure = true)
    private Class<T> getClazz() {
        return clazz;
    }


}
