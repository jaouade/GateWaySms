package com.sms.service;

import com.sms.dao.DeliveryDao;
import com.sms.dao.IDao;
import com.sms.entities.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class DeliveryService  extends Service<Delivery> implements IDeliveryService {
    private DeliveryDao deliveryDao;
    public DeliveryService(){

    }
    @Autowired
    public DeliveryService(
            @Qualifier("deliveryDao") IDao<Delivery> genericDao) {
        super(genericDao);
        this.deliveryDao = (DeliveryDao) genericDao;
    }
}
