package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.SmsDao;
import com.sms.entities.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SmsService extends Service<Sms> implements ISmsService {
    private SmsDao smsDao;
    public SmsService(){

    }
    @Autowired
    public SmsService(
            @Qualifier("smsDao") IDao<Sms> genericDao) {
        super(genericDao);
        this.smsDao= (SmsDao) genericDao;
    }

}
