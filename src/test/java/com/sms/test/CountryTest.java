package com.sms.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.ICountryDao;
import com.sms.entities.Country;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CountryTest {


    @Autowired
    @Qualifier("countrydao")
    private ICountryDao countryyDao;


    @Test
    public void AaddTest() {
        Country c = countryyDao.save(new Country("Maroc"));
        Assert.assertNotNull(c);

    }

    @Test
    public void BupdateTest() {
        Country c = countryyDao.save(new Country("spain"));
        c.setCountryName("Maroc");
        countryyDao.update(c);
        Assert.assertEquals("Maroc", c.getCountryName());

    }

    @Test
    public void CdeletTest() {
        Country c = countryyDao.save(new Country("USA"));
        countryyDao.delete(c);
        c = countryyDao.get(c.getIdCountry());
        Assert.assertNull(c);

    }

}
