package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.SmsTemplateDao;
import com.sms.entities.Account;
import com.sms.entities.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@org.springframework.stereotype.Service
public class SmsTemplateService extends Service<SmsTemplate> implements ISmsTemplateService {
    private SmsTemplateDao smsTemplateDao;
    public SmsTemplateService(){

    }
    @Autowired
    public SmsTemplateService(
            @Qualifier("smsTemplateDao") IDao<SmsTemplate> genericDao) {
        super(genericDao);
        this.smsTemplateDao= (SmsTemplateDao) genericDao;
    }

    @Override
    public List<SmsTemplate> getAllByAccount(Account acc) {
        return smsTemplateDao.getAllByAccount(acc);
    }
}
