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
import com.sms.dao.ILogHistoryDao;
import com.sms.entities.Account;
import com.sms.entities.City;
import com.sms.entities.Client;
import com.sms.entities.Credential;
import com.sms.entities.LogHistory;
import com.sms.entities.Sector;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LogHistoryTest {
    @Autowired
    @Qualifier("loghistorydao")
    private ILogHistoryDao logDao;

    @Test
    public void AaddTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2", "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        LogHistory log = logDao.save(new LogHistory("delete", new Date(), a));
        Assert.assertNotNull(log);

    }

    @Test
    public void BupdateTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2",  "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        LogHistory log = logDao.save(new LogHistory("delete", new Date(), a));
        log.setOperation("update");

        logDao.update(log);
        LogHistory l2 = logDao.get(log.getIdLog());
        Assert.assertEquals(l2.getOperation(), log.getOperation());

    }

    @Test
    public void CdeletTest() {
        Client client = new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222",
                3333, 333, new City("fes"), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login1", "password2",  "Role_User");
        Account a = new Account(client, credential, 333, 2222);
        LogHistory log = logDao.save(new LogHistory("delete", new Date(), a));
        logDao.delete(log);
        log = logDao.get(log.getIdLog());
        Assert.assertNull(log);

    }

}
