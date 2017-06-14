package com.sms.service;

import com.sms.dao.CityDao;
import com.sms.dao.IDao;
import com.sms.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class CityService extends Service<City> implements IcityService {
    private CityDao cityDao;
    public CityService(){

    }
    @Autowired
    public CityService(
            @Qualifier("cityDao") IDao<City> genericDao) {
        super(genericDao);
        this.cityDao = (CityDao) genericDao;
    }
}
