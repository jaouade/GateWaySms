package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.PhoneBookDao;
import com.sms.entities.Account;
import com.sms.entities.PhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@org.springframework.stereotype.Service
public class PhoneBookService extends Service<PhoneBook> implements IPhoneBookService {
    private PhoneBookDao phoneBookDao;
    public PhoneBookService(){

    }
    @Autowired
    public PhoneBookService(
            @Qualifier("phoneBookDao") IDao<PhoneBook> genericDao) {
        super(genericDao);
        this.phoneBookDao = (PhoneBookDao) genericDao;
    }

    @Override
    public List<PhoneBook> getAllByAccount(Account acc) {
        return phoneBookDao.getAllByAccount(acc);
    }
}
