package com.sms.dao;

import com.sms.entities.Client;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDao extends Dao<Client> implements IClientDao {

    @Override
    public  int updateCredit(double remCrd){
        Query query = currentSession().createQuery("update Client set remaining_credit = :rmcrd");
        query.setParameter("rmcrd", remCrd);
        return  query.executeUpdate();
    }
   
}
