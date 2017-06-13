package com.sms.dao;

import com.sms.entities.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class AdminDa extends Dao<Admin> implements IAdminDa {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Admin get(Long id) {
        return (Admin) sessionFactory.getCurrentSession().get(Admin.class, id);

    }

    @Override
    public Admin save(Admin object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Admin object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Admin object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Admin> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Admin> ts = session.createCriteria(Admin.class).list();

        return ts;
    }

}
