package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.RechargeSimDao;
import com.sms.entities.RechargeSim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class RechargeSimService extends Service<RechargeSim> implements IRechargeSimService {

    private RechargeSimDao rechargeSimDao;
    public RechargeSimService(){

    }
    @Autowired
    public RechargeSimService(
            @Qualifier("rechargeSimDao") IDao<RechargeSim> genericDao) {
        super(genericDao);
        this.rechargeSimDao = (RechargeSimDao) genericDao;
    }
}
