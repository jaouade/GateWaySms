package com.sms.dao;

import com.sms.entities.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("clientdao")
public class ClientDao extends Dao<Client> implements IClientDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Client get(Long id) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);

    }

    @Override
    public Client save(Client object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Client object) {
        sessionFactory.getCurrentSession().update(object);
        sessionFactory.getCurrentSession().flush();
    }
    @Override
    public  int updateCredit(double remCrd){
        Query query = sessionFactory.getCurrentSession().createQuery("update Client set remaining_credit = :rmcrd");
        query.setParameter("rmcrd", remCrd);
        return  query.executeUpdate();
    }
    @Override
    public void delete(Client object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Client> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Client> ts = session.createCriteria(Client.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
