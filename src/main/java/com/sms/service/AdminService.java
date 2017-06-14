package com.sms.service;

import com.sms.dao.AdminDao;
import com.sms.dao.IDao;
import com.sms.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
@org.springframework.stereotype.Service
public class AdminService extends Service<Admin> implements IAdminService {
    private AdminDao adminDao;
    public AdminService(){

    }
    @Autowired
    public AdminService(
            @Qualifier("adminDao") IDao<Admin> genericDao) {
        super(genericDao);
        this.adminDao = (AdminDao) genericDao;
    }
}
