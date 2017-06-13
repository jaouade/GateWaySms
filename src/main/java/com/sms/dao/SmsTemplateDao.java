package com.sms.dao;

import com.sms.entities.Account;
import com.sms.entities.SmsTemplate;
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
@Component("smstemplatedao")
public class SmsTemplateDao extends Dao<SmsTemplate> implements ISmsTemplateDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SmsTemplate get(Long id) {
        return (SmsTemplate) sessionFactory.getCurrentSession().get(SmsTemplate.class, id);

    }

    @Override
    public SmsTemplate save(SmsTemplate object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(SmsTemplate object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(SmsTemplate object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<SmsTemplate> getAll() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<SmsTemplate> ts = session.createCriteria(SmsTemplate.class).list();
        return ts;
    }

    @Override
    public List<SmsTemplate> getAllByAccount(Account acc) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery(
                "from SmsTemplate s WHERE s.account.idAccount=:id");
        q.setParameter("id", acc.getIdAccount());
        @SuppressWarnings("unchecked")
        List<SmsTemplate> smstps = q.list();
        return smstps;
    }
}
