package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.SmsOrderDao;
import com.sms.entities.SmsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SmsOrderService extends Service<SmsOrder> implements ISmsOrderService {
    private SmsOrderDao smsOrderDao;
    public SmsOrderService(){

    }
    @Autowired
    public SmsOrderService(
            @Qualifier("smsOrderDao") IDao<SmsOrder> genericDao) {
        super(genericDao);
        this.smsOrderDao= (SmsOrderDao) genericDao;
    }
}
