package com.sms.service;

import com.sms.dao.CredentialDao;
import com.sms.dao.IDao;
import com.sms.entities.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class CredentialService extends Service<Credential> implements ICredentialService {
    private CredentialDao credentialDao;
    public CredentialService(){

    }
    @Autowired
    public CredentialService(
            @Qualifier("credentialDao") IDao<Credential> genericDao) {
        super(genericDao);
        this.credentialDao = (CredentialDao) genericDao;
    }
}
