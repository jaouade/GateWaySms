package com.sms.service;

import com.sms.dao.ClientDao;
import com.sms.dao.IDao;
import com.sms.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class ClientService extends Service<Client> implements IClientService {
    private ClientDao clientDao;
    public ClientService(){

    }
    @Autowired
    public ClientService(
            @Qualifier("clientDao") IDao<Client> genericDao) {
        super(genericDao);
        this.clientDao = (ClientDao) genericDao;
    }
}
