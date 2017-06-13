package com.sms.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sms.config.HibernateConfiguration;
import com.sms.entities.City;
import com.sms.entities.Country;
import com.sms.service.IcityService;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CityTest {

    @Autowired
    @Qualifier("cityservice")
    private IcityService cityDao;

    @Test
    public void AaddTest() {
        City city = cityDao.save(new City("casablanca", new Country("Maroc")));
        Assert.assertNotNull(city);

    }

    @Test
    public void BupdateTest() {
        City city = cityDao.save(new City("casablanca", new Country("Maroc")));
        city.setCityName("rabat");
        cityDao.update(city);
        Assert.assertEquals("rabat", city.getCityName());

    }

    @Test
    public void CdeletTest() {
        City city = cityDao.save(new City("casablanca", new Country("Maroc")));
        cityDao.delete(city);
        city = cityDao.get(city.getIdCity());
        Assert.assertNull(city);

    }

}
