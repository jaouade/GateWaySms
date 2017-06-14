package com.sms.dao;

import com.sms.entities.Account;
import com.sms.entities.SmsTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ISmsTemplateDao extends IDao<SmsTemplate> {

     List<SmsTemplate> getAllByAccount(Account acc);
}

