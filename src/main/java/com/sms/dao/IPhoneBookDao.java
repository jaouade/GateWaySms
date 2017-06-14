package com.sms.dao;

import com.sms.entities.Account;
import com.sms.entities.PhoneBook;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface IPhoneBookDao extends IDao<PhoneBook> {

     List<PhoneBook> getAllByAccount(Account acc);
}
