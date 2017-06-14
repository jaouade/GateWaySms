package com.sms.service;

import com.sms.entities.Account;
import com.sms.entities.SmsTemplate;

import java.util.List;

public interface ISmsTemplateService extends Iservice<SmsTemplate> {
    List<SmsTemplate> getAllByAccount(Account acc);
}
