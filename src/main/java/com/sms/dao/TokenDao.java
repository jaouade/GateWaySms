package com.sms.dao;

import com.sms.entities.Token;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("tokendao")
public class TokenDao extends Dao<Token> implements ITokenDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Token get(Long id) {
        return (Token) sessionFactory.getCurrentSession().get(Token.class, id);

    }

    @Override
    public Token save(Token object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public void update(Token object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Token object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public List<Token> getAll() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Token> ts = session.createCriteria(Token.class).list();
        return ts;
    }

    @Override
    public Token getTokenByToken(String token) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Token t where t.token = :token ");
        query.setParameter("token", token);
        return  (Token) query.uniqueResult();
    }
    @Override
    public Token getTokenByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Token t where t.email = :email ");
        query.setParameter("email", email);
        return (Token) query.uniqueResult();
    }

}
