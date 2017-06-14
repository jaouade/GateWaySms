package com.sms.service;

import java.util.List;

public interface Iservice<T> {
    T get(Long id);

    T save(T object);

    void update(T object);

    void delete(T object);

    List<T> getAll();


}
