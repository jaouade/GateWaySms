package com.sms.service;

import com.sms.entities.Account;
import com.sms.entities.PhoneBook;

import java.util.List;

public interface IPhoneBookService  extends  Iservice<PhoneBook>{
    List<PhoneBook> getAllByAccount(Account acc);
}
