package com.sms.dao;

import com.sms.entities.Account;
import com.sms.entities.PhoneBook;

import java.util.List;

public interface IPhoneBookDao extends IDao<PhoneBook> {

    public List<PhoneBook> getAllByAccount(Account acc);
}
