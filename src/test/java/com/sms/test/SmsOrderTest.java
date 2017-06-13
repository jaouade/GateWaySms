package com.sms.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.ISmsOrderDao;
import com.sms.entities.Account;
import com.sms.entities.City;
import com.sms.entities.Client;
import com.sms.entities.Credential;
import com.sms.entities.Sector;
import com.sms.entities.SmsOrder;
import com.sms.entities.SmsPrice;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SmsOrderTest {

    @Autowired
    @Qualifier("smsorderdao")
    private ISmsOrderDao soDap;

    @Test
    public void AaddTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2",  "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        SmsPrice smsPrice = new SmsPrice(3333, 3.3, 14.0);
        SmsOrder smso = soDap.save(new SmsOrder(a, 4567, 4567, smsPrice, 1.2, 222, new Date(), "status"));
        Assert.assertNotNull(smso);

    }

    @Test
    public void BupdateTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2",  "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        SmsPrice smsPrice = new SmsPrice(3333, 3.3, 14.0);
        SmsOrder smso = soDap.save(new SmsOrder(a, 4567, 4567, smsPrice, 1.2, 222, new Date(), "status"));
        smso.setQuantity(22222222);
        soDap.update(smso);
        SmsOrder order = soDap.get(smso.getIdSmsOrder());
        Assert.assertEquals(order.getQuantity(), smso.getQuantity());

    }

    @Test
    public void CdeletTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2", "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        SmsPrice smsPrice = new SmsPrice(3333, 3.3, 14.0);
        SmsOrder smso = soDap.save(new SmsOrder(a, 4567, 4567, smsPrice, 1.2, 222,  new Date(), "status"));
        soDap.delete(smso);
        smso = soDap.get(smso.getIdSmsOrder());
        Assert.assertNull(smso);

    }

}
