package com.sms.dao;

import com.sms.entities.LogHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Component("loghistorydao")
public class LogHistoryDao extends Dao<LogHistory> implements ILogHistoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public LogHistory get(Long id) {
        return (LogHistory) sessionFactory.getCurrentSession().get(LogHistory.class, id);

    }

    @Override
    public LogHistory save(LogHistory object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(LogHistory object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(LogHistory object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<LogHistory> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<LogHistory> ts = session.createCriteria(LogHistory.class).list();
        session.getTransaction().commit();
        session.close();
        return ts;
    }

}
