package com.sms.service;

import com.sms.entities.Sector;

@org.springframework.stereotype.Service
public class SectorService extends Service<Sector> implements ISectorService {
   /* private SectorDao sectorDao;

    public SectorService() {

    }

    @Autowired
    public SectorService(
            @Qualifier("sectorDao") IDao<Sector> genericDao) {
        super(genericDao);
        this.sectorDao = (SectorDao) genericDao;
    }*/
}
