package com.sms.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.IAdminDa;
import com.sms.entities.Admin;
import com.sms.entities.Credential;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestA {
    @Autowired
    private IAdminDa adminDa;

    @Test
    public void AaddTest() {
        Admin a = adminDa.save(
                new Admin(new Credential("admin", "admin", "Role_Admin"), "jaouad", "jaouad@com.com"));
        Assert.assertNotNull(a);

    }

    @Test
    public void BupdateTest() {
        Admin a = adminDa
                .save(new Admin(new Credential("admin1", "admin1",  "Role_Admin"), "ali", "ali@com.com"));
        a.setMail("ali2@ali.com");
        adminDa.update(a);
        Assert.assertEquals("ali2@ali.com", a.getMail());

    }

    @Test
    public void CdeletTest() {
        Admin a = adminDa.save(
                new Admin(new Credential("admin", "admin",  "Role_Admin"), "jaouad", "jaouad@com.com"));
        adminDa.delete(a);
        a = adminDa.get(a.getIdAdmin());
        Assert.assertNull(a);

    }

}