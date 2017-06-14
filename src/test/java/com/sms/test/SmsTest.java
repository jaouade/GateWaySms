package com.sms.test;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.ISmsDao;
import com.sms.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SmsTest {

    @Autowired
    @Qualifier("smsdao")
    private ISmsDao smsDao;

    @Test
    public void AaddTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1test", "password2test",  "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        Delivery delivery = new Delivery(a, new Date(), 222);
        PhoneNumber phoneNumber = new PhoneNumber("test", "3456789", new PhoneBook("name", a));
        Compagne compagne = new Compagne("design1", a);
        SimCard simCard = new SimCard("456789", new Date(), "orange", 2222, 22);
        Sms s = smsDao.save(new Sms(a, delivery, phoneNumber, simCard, "hello", new Date(), "sent"));
        Assert.assertNotNull(s);

    }

    @Test
    public void BupdateTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1test", "password2test", "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        Delivery delivery = new Delivery(a, new Date(), 222);
        PhoneNumber phoneNumber = new PhoneNumber("test", "3456789", new PhoneBook("name", a));
        Compagne compagne = new Compagne("design1", a);
        SimCard simCard = new SimCard("456789", new Date(), "orange", 2222, 22);
        Sms s = smsDao.save(new Sms(a, delivery, phoneNumber, simCard, "hello", new Date(), "sent"));
        s.setStatus("error in sending");
        smsDao.update(s);
        Sms sms = smsDao.get(s.getIdSms());
        Assert.assertEquals(s.getStatus(), sms.getStatus());

    }

    @Test
    public void CdeletTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1test", "password2test",  "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        Delivery delivery = new Delivery(a, new Date(), 222);
        PhoneNumber phoneNumber = new PhoneNumber("test", "3456789", new PhoneBook("name", a));
        Compagne compagne = new Compagne("design1", a);
        SimCard simCard = new SimCard("456789", new Date(), "orange", 2222, 22);
        Sms s = smsDao.save(new Sms(a, delivery, phoneNumber, simCard, "hello", new Date(), "sent"));
        smsDao.delete(s);
        s = smsDao.get(s.getIdSms());
        Assert.assertNull(s);

    }

}
