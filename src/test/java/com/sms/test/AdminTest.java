package com.sms.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.IAdminDao;
import com.sms.entities.Admin;
import com.sms.entities.Credential;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminTest {
    @Autowired
    @Qualifier("admindao")
    private IAdminDao adminDao;


    @Test
    public void AaddTest() {
        Admin a = adminDao.save(new Admin(new Credential("admintxfgesdst", "admintest",  "Role_Admin"), "jaouad", "jaofduad@com.com"));
        Assert.assertNotNull(a);

    }

    @Test
    public void BupdateTest() {
        Admin a = adminDao.save(new Admin(new Credential("admin3tdsgfsdest", "admin3test",  "Role_Admin"), "ali", "alfi@com.com"));
        a.setMail("ali2@ali.com");
        adminDao.update(a);
        Assert.assertEquals("ali2@ali.com", a.getMail());

    }

    @Test
    public void CdeletTest() {
        Admin a = adminDao.save(new Admin(new Credential("admin2tesdsfzast", "admin2test", "Role_Admin"), "jaouad", "jaoufad@com.com"));
        adminDao.delete(a);
        a = adminDao.get(a.getIdAdmin());
        Assert.assertNull(a);

    }


}
