package com.sms.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.IAccountDao;
import com.sms.dao.ICityDao;
import com.sms.dao.IClientDao;
import com.sms.dao.ICountryDao;
import com.sms.dao.ICredentialDao;
import com.sms.dao.ISectorDao;
import com.sms.entities.Account;
import com.sms.entities.City;
import com.sms.entities.Client;
import com.sms.entities.Country;
import com.sms.entities.Credential;
import com.sms.entities.Sector;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CredentialTest {
    @Autowired
    private ICredentialDao credentialDao;
    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private IClientDao clientDao;
    @Autowired
    private ICountryDao countryDao;
    @Autowired
    private ICityDao cityDao;
    @Autowired
    private ISectorDao sectorDao;

    @Test
    public void test() {
        Credential cred = new Credential("login", "111",  "superuser");

        cred = credentialDao.save(cred);
        Credential cred1 = credentialDao.get(cred.getIdCredential());
        Assert.assertNotNull(cred1);

    }

    @Test
    public void testAccount() {
        Country country = countryDao.save(new Country("spain"));
        City city = cityDao.save(new City("lisbone	", country));
        Sector sector = sectorDao.save(new Sector("sec1", "desc1"));
        Client client = clientDao.save(new Client("corp_na", "test", "22200", "email@email.com", "adresse", "0765432156", "05 566777777", 2222, 23, city, sector));

        Credential cred = credentialDao.save(new Credential("test", "test",  "Role_Admin"));
        Account account = new Account(client, cred, 33333, 22);
        Account a2 = accountDao.save(account);

        Account a = accountDao.getAcountByLogin("test");
        Assert.assertNotNull(a);
    }

}
