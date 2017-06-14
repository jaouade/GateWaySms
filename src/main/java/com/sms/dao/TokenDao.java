package com.sms.dao;

import com.sms.entities.Token;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@SuppressWarnings("ALL")
@Repository
public class TokenDao extends Dao<Token> implements ITokenDao {

    @Override
    public Token getTokenByToken(String token) {
        Session session = currentSession();
        Query query = session.createQuery("from Token t where t.token = :token ");
        query.setParameter("token", token);
        return  (Token) query.uniqueResult();
    }
    @Override
    public Token getTokenByEmail(String email) {
        Session session = currentSession();
        Query query = session.createQuery("from Token t where t.email = :email ");
        query.setParameter("email", email);
        return (Token) query.uniqueResult();
    }

}
