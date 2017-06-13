package com.sms.dao;

import com.sms.entities.PhoneNumber;

import java.util.List;

public interface IPhoneNumberDao extends IDao<PhoneNumber> {
    public List<PhoneNumber> getAllByPhoneBook(long id);

    public List<PhoneNumber> getAllPhoneNumberByPhoneBookAndAccount(long id);


}
