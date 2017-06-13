package com.sms.dao;

import com.sms.entities.City;

public interface ICityDao extends IDao<City> {
    public int deleteAll();
}
