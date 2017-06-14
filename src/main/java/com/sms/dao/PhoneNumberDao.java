package com.sms.dao;

import com.sms.entities.PhoneNumber;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PhoneNumberDao extends Dao<PhoneNumber> implements IPhoneNumberDao {

    @Override
    public List<PhoneNumber> getAllByPhoneBook(long id) {
        Session session = currentSession();
        Query q = session.createQuery("from PhoneNumber p WHERE p.phoneBook.idPhoneBook=:id");
        q.setParameter("id", id);
        @SuppressWarnings("unchecked")
        List<PhoneNumber> smstps = q.list();
        return smstps;
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumberByPhoneBookAndAccount(long id) {
        Session session = currentSession();
        Query q = session.createQuery("from PhoneNumber p WHERE p.phoneBook.account.idAccount=:id");
        q.setParameter("id", id);
        @SuppressWarnings("unchecked")
        List<PhoneNumber> smstps = q.list();
        return smstps;
    }

}
