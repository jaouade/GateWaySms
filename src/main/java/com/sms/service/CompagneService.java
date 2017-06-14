package com.sms.service;

import com.sms.dao.CompagneDao;
import com.sms.dao.IDao;
import com.sms.entities.Compagne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class CompagneService extends Service<Compagne> implements ICompagneService {
    private CompagneDao compagneDao;
    public CompagneService(){

    }
    @Autowired
    public CompagneService(
            @Qualifier("compagneDao") IDao<Compagne> genericDao) {
        super(genericDao);
        this.compagneDao = (CompagneDao) genericDao;
    }
}
