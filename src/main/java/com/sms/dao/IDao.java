package com.sms.dao;

import java.util.List;


public interface IDao<T> {
     T get(Long id);

    T save(T object);

    void update(T object);

    void delete(T object);

    List<T> getAll();

}
