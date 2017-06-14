package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.SectorDao;
import com.sms.entities.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SectorService extends Service<Sector> implements ISectorService {
    private SectorDao sectorDao;
    public SectorService(){

    }
    @Autowired
    public SectorService(
            @Qualifier("sectorDao") IDao<Sector> genericDao) {
        super(genericDao);
        this.sectorDao= (SectorDao) genericDao;
    }
}
