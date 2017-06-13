package com.sms.service;

import com.sms.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public abstract class Service<T> implements Iservice<T> {

    @Autowired
    @Qualifier("citydao")
    IDao<T> dao;
    private Class<T> clazz;

    public Service(IDao<T> idao) {
        this.dao = idao;
    }

    public Service() {

    }

    @Override
    public T get(Long id) {
        return dao.get(id);

    }

    @Override
    public T save(T object) {

        return dao.save(object);
    }

    @Override
    public void update(T object) {
        dao.update(object);
    }

    @Override
    public void delete(T object) {
        dao.delete(object);
    }

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    public String getClazz() {
        return clazz.getName();
    }

}
