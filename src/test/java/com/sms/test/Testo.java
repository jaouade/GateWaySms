package com.sms.test;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.IAccountDao;
import com.sms.dao.ISmsTemplateDao;
import com.sms.entities.Account;
import com.sms.entities.SmsTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class Testo {
    @Autowired
    private ISmsTemplateDao stdao;
    @Autowired
    private IAccountDao adao;


    @Test
    public void AaddTest() {
        List<SmsTemplate> list = stdao.getAll();
        for (int i = 0; i < list.size(); i++) {

            //System.out.println(list.get(i).getName());
        }
        Assert.assertEquals(9, list.size());

    }

    @Test
    public void test() {
        Account account = adao.get(7L);
        Assert.assertNull(account);

    }

    @Test
    public void testi() {
        List<Account> list = adao.getAll();
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getCredential().getLogin());
        }
        List<SmsTemplate> smsTemplates = stdao.getAllByAccount(list.get(0));
        for (int i = 0; i < smsTemplates.size(); i++) {

            System.out.println(smsTemplates.get(i).getName());
        }
        Assert.assertEquals(9, smsTemplates.size());


    }


}
