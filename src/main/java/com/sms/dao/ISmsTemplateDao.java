package com.sms.dao;

import com.sms.entities.Account;
import com.sms.entities.SmsTemplate;

import java.util.List;

public interface ISmsTemplateDao extends IDao<SmsTemplate> {


    public List<SmsTemplate> getAllByAccount(Account acc);
}

