package com.sms.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.IDeliveryDao;
import com.sms.entities.Delivery;
import com.sms.entities.Account;
import com.sms.entities.City;
import com.sms.entities.Client;
import com.sms.entities.Credential;
import com.sms.entities.Delivery;
import com.sms.entities.Sector;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DeliveryTest {
    @Autowired
    private IDeliveryDao deliveryDao;

    @Test
    public void AaddTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222", 3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2",  "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        Delivery delivery = deliveryDao.save(new Delivery(a, new Date(), 222));
        Assert.assertNotNull(delivery);

    }

    @Test
    public void BupdateTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222", 3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2", "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        Delivery delivery = deliveryDao.save(new Delivery(a, new Date(), 222));
        delivery.setTotalSms(789867);
        deliveryDao.update(delivery);
        Delivery d2 = deliveryDao.get(delivery.getIdDelivery());
        Assert.assertEquals(d2.getTotalSms(), delivery.getTotalSms());

    }

    @Test
    public void CdeletTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222", 3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2", "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        Delivery delivery = deliveryDao.save(new Delivery(a, new Date(), 222));
        deliveryDao.delete(delivery);
        delivery = deliveryDao.get(delivery.getIdDelivery());
        Assert.assertNull(delivery);

    }

}
