package com.sms.dao;

import com.sms.entities.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDao extends IDao<Client> {
      int updateCredit(double remCrd);
}
