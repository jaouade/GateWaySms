package com.sms.service;

import com.sms.entities.PhoneNumber;

import java.util.List;

public interface IPhoneNumberService extends Iservice<PhoneNumber> {
    List<PhoneNumber> getAllByPhoneBook(long id);

    List<PhoneNumber> getAllPhoneNumberByPhoneBookAndAccount(long id);

}
