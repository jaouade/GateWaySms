package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.PhoneNumberDao;
import com.sms.entities.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@org.springframework.stereotype.Service
public class PhoneNumberService extends Service<PhoneNumber> implements IPhoneNumberService {
    private PhoneNumberDao phoneNumberDao;
    public PhoneNumberService(){

    }
    @Autowired
    public PhoneNumberService(
            @Qualifier("phoneNumberDao") IDao<PhoneNumber> genericDao) {
        super(genericDao);
        this.phoneNumberDao = (PhoneNumberDao) genericDao;
    }

    @Override
    public List<PhoneNumber> getAllByPhoneBook(long id) {
        return phoneNumberDao.getAllByPhoneBook(id);
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumberByPhoneBookAndAccount(long id) {
        return phoneNumberDao.getAllPhoneNumberByPhoneBookAndAccount(id);
    }
}
