package com.sms.test;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.ISimCardDao;
import com.sms.entities.SimCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimCardTest {

    @Autowired
    private ISimCardDao simCardDao;

    @Test
    public void AaddTest() {
        SimCard sim = simCardDao.save(new SimCard("4567890", new Date(), "inwi", 222, 33));
        Assert.assertNotNull(sim);

    }

    @Test
    public void BupdateTest() {
        SimCard sim = simCardDao.save(new SimCard("4567890", new Date(), "inwi", 222, 33));
        sim.setCreditSms(99);
        simCardDao.update(sim);
        SimCard card = simCardDao.get(sim.getIdSimCard());
        Assert.assertEquals(sim.getCreditSms(), card.getCreditSms());

    }

    @Test
    public void CdeletTest() {
        SimCard sim = simCardDao.save(new SimCard("4567890", new Date(), "inwi", 222, 33));
        simCardDao.delete(sim);
        sim = simCardDao.get(sim.getIdSimCard());
        Assert.assertNull(sim);

    }

}
