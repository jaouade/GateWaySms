package com.sms.dao;

import com.sms.entities.Account;
import com.sms.entities.SmsTemplate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SmsTemplateDao extends Dao<SmsTemplate> implements ISmsTemplateDao {

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<SmsTemplate> getAllByAccount(Account acc) {
        Session session = currentSession();
        Query q = session.createQuery(
                "from SmsTemplate s WHERE s.account.idAccount=:id");
        q.setParameter("id", acc.getIdAccount());
        @SuppressWarnings("unchecked")
        List<SmsTemplate> smstps = q.list();
        return smstps;
    }
}
