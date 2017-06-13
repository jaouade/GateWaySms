package com.sms.dao;

import com.sms.entities.Admin;

import java.util.List;

public interface IAdminDa extends IDao<Admin> {
    public Admin get(Long id);

    public Admin save(Admin object);

    public void update(Admin object);

    public void delete(Admin object);

    public List<Admin> getAll();
}
