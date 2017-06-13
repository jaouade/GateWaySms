package com.sms.dao;

import com.sms.entities.Credential;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("credentialdao")
public class CredentialDao extends Dao<Credential> implements ICredentialDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Credential get(Long id) {
        return (Credential) sessionFactory.getCurrentSession().get(Credential.class, id);

    }

    @Override
    public Credential save(Credential object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Credential object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Credential object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Credential> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Credential> ts = session.createCriteria(Credential.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
