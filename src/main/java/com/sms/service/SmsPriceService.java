package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.SmsPriceDao;
import com.sms.entities.SmsPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SmsPriceService extends Service<SmsPrice> implements ISmsPriceService {

    private SmsPriceDao  smsPriceDao;
    public SmsPriceService(){

    }
    @Autowired
    public SmsPriceService(
            @Qualifier("smsPriceDao") IDao<SmsPrice> genericDao) {
        super(genericDao);
        this.smsPriceDao= (SmsPriceDao) genericDao;
    }
}
