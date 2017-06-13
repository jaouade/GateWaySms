package com.sms.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.IAccountDao;
import com.sms.entities.Account;
import com.sms.entities.City;
import com.sms.entities.Client;
import com.sms.entities.Country;
import com.sms.entities.Credential;
import com.sms.entities.Sector;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountTest {
    @Autowired
    @Qualifier("accountdao")
    private IAccountDao accountDao;

    @Test
    public void AaddTest() {
        Client client = new Client("corp", "name", "202020", "corp@corp.com", "bd ...", "222239393", "33332222", 3333, 333, new City("fes", new Country("maroc")), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login", "password", "Role_User");
        Account a = accountDao.save(new Account(client, credential, 222, 2222));
        Assert.assertNotNull(a);

    }

//	@Test
//	public void BupdateTest() {
//		Client client= new Client("corp1", "name1", "202020", "corp1@corp.com", "bd ...", "222239393", "33332222", 3333, 333, new City("fes"), new Sector("sec4", "desc4"));
//		Credential credential =  new Credential("login1@login", "password2", true, "mmm", "Role_User");
//		Account a = accountDao.save(
//				new Account(client, credential, 333	, 2222));
//		a.setTreshold(22);
//		accountDao.update(a);
//		Account a2 = accountDao.get(a.getIdAccount());
//		Assert.assertEquals(a2.getTreshold(), a.getTreshold());
//
//	}
//
//	@Test
//	public void CdeletTest() {
//		Client client= new Client("corp1", "name1", "202020", "corp1o@corp.com", "bd ...", "222239393", "33332222", 3333, 333, new City("fes"), new Sector("sec4", "desc4"));
//		Credential credential =  new Credential("login1@lofgin", "password2", true, "mmm", "Role_User");
//		Account a = accountDao.save(
//				new Account(client, credential, 333	, 2222));
//		accountDao.delete(a);
//		a = accountDao.get(a.getIdAccount());
//		Assert.assertNull(a);
//
//	}

}
