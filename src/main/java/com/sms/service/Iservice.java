package com.sms.service;

import java.util.List;

public interface Iservice<T> {
    public T get(Long id);

    public T save(T object);

    public void update(T object);

    public void delete(T object);

    public List<T> getAll();


}
