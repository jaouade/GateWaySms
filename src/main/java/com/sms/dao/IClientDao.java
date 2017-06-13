package com.sms.dao;

import com.sms.entities.Client;

public interface IClientDao extends IDao<Client> {
      int updateCredit(double remCrd);
}
