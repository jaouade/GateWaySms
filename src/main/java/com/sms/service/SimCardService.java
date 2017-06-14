package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.SimCardDao;
import com.sms.entities.SimCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SimCardService extends Service<SimCard> implements ISimCardService {
    private SimCardDao simCardDao;
    public SimCardService(){

    }
    @Autowired
    public SimCardService(
            @Qualifier("simCardDao") IDao<SimCard> genericDao) {
        super(genericDao);
        this.simCardDao= (SimCardDao) genericDao;
    }
}
