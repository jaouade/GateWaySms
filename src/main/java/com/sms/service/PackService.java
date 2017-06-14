package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.PackDao;
import com.sms.entities.Pack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class PackService extends Service<Pack> implements IPackService {
    private PackDao packDao;

    public PackService() {

    }

    @Autowired
    public PackService(
            @Qualifier("packDao") IDao<Pack> genericDao) {
        super(genericDao);
        this.packDao = (PackDao) genericDao;
    }
}
