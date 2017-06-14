package com.sms.dao;

import com.sms.entities.Account;
import com.sms.entities.PhoneBook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneBookDao extends Dao<PhoneBook> implements IPhoneBookDao {
    @Override
    public List<PhoneBook> getAllByAccount(Account acc) {
        Session session = currentSession();
        Query q = session.createQuery("from PhoneBook p WHERE p.account.idAccount=:id");
        q.setParameter("id", acc.getIdAccount());
        @SuppressWarnings("unchecked")
        List<PhoneBook> phbs = q.list();

        return phbs;
    }

}
