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
import com.sms.dao.IPhoneBookDao;
import com.sms.entities.PhoneBook;
import com.sms.entities.Sector;
import com.sms.entities.Account;
import com.sms.entities.City;
import com.sms.entities.Client;
import com.sms.entities.Country;
import com.sms.entities.Credential;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneBookTest {

    @Autowired
    @Qualifier("phonebookdao")
    private IPhoneBookDao phbda;
    @Autowired
    private IAccountDao accountDao;

    @Test
    public void AaddTest() {
        Client client = new Client("corp", "name", "202020", "corp@corp.com", "bd ...", "222239393", "33332222", 3333, 333, new City("fes", new Country("maroc")), new Sector("sec4", "desc4"));
        Credential credential = new Credential("login@lossg2", "password",  "Role_Admin");
        Account a = accountDao.save(new Account(client, credential, 222, 2222));
        PhoneBook php = phbda.save(new PhoneBook("casablanca", a));
        PhoneBook book = phbda.get(php.getIdPhoneBook());
        System.err.println(book.getBookName());
        Assert.assertNotNull(a);

    }


}
