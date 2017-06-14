package com.sms.test;

import com.sms.config.HibernateConfiguration;
import com.sms.dao.ISectorDao;
import com.sms.entities.Sector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SectorTest {


    @Autowired
    private ISectorDao sectorDao;


    @Test
    public void AaddTest() {
        Sector s = sectorDao.save(new Sector("sec1", "dec1"));
        Assert.assertNotNull(s);

    }

    @Test
    public void BupdateTest() {
        Sector s = sectorDao.save(new Sector("sec2", "dec2"));
        s.setDescription("update desc");
        sectorDao.update(s);
        Sector s2 = sectorDao.get(s.getIdSector());
        Assert.assertEquals(s2.getDescription(), s.getDescription());

    }

    @Test
    public void CdeletTest() {
        Sector s = sectorDao.save(new Sector("desc2", "sec3"));
        sectorDao.delete(s);
        s = sectorDao.get(s.getIdSector());
        Assert.assertNull(s);

    }

}
