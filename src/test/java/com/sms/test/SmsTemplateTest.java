package com.sms.test;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.ISmsTemplateDao;
import com.sms.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SmsTemplateTest {

    @Autowired
    @Qualifier("smstemplatedao")
    private ISmsTemplateDao stDao;

    @Test
    public void AaddTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2",  "Role_User");
        Account account = new Account(client, credential, 333, 2222);
        SmsTemplate st = stDao.save(new SmsTemplate("bonjour, je suis occupé!!", account));
        Assert.assertNotNull(st);

    }

    @Test
    public void BupdateTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2",  "Role_User");
        Account account = new Account(client, credential, 333, 2222);
        SmsTemplate st = stDao.save(new SmsTemplate("bonjour, je suis occupé!!", account));
        st.setSmsTemplate("bonsoir, je suis pas a la maison");
        stDao.update(st);
        SmsTemplate smsTemplate = stDao.get(st.getIdSmsTemplate());
        Assert.assertEquals(smsTemplate.getSmsTemplate(), st.getSmsTemplate());

    }

    @Test
    public void CdeletTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2",  "Role_User");
        Account account = new Account(client, credential, 333, 2222);
        SmsTemplate st = stDao.save(new SmsTemplate("bonjour, je suis occupé!!", account));
        stDao.delete(st);
        st = stDao.get(st.getIdSmsTemplate());
        Assert.assertNull(st);

    }

}
