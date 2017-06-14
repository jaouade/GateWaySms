package com.sms.service;

import com.sms.dao.IDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@org.springframework.stereotype.Service
@Transactional
public abstract class Service<T> implements Iservice<T> {


    private IDao<T> dao;

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


}
