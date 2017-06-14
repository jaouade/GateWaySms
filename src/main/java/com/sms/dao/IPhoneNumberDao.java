package com.sms.dao;

import com.sms.entities.PhoneNumber;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface IPhoneNumberDao extends IDao<PhoneNumber> {
     List<PhoneNumber> getAllByPhoneBook(long id);

     List<PhoneNumber> getAllPhoneNumberByPhoneBookAndAccount(long id);


}
