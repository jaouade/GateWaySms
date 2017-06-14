package com.sms.service;

import com.sms.dao.CountryDao;
import com.sms.dao.IDao;
import com.sms.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class CountryService extends Service<Country> implements ICountryService {
    private CountryDao countryDao;
    public CountryService(){

    }
    @Autowired
    public CountryService(
            @Qualifier("countryDao") IDao<Country> genericDao) {
        super(genericDao);
        this.countryDao = (CountryDao) genericDao;
    }
}
