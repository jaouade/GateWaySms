package com.sms.restController;

import com.sms.entities.Account;
import com.sms.entities.PhoneBook;
import com.sms.entities.PhoneNumber;
import com.sms.service.IPhoneBookService;
import com.sms.service.IPhoneNumberService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("phoneNumber")
public class RestPhoneNumber {
    private Logger log = Logger.getLogger(RestPhoneNumber.class);

    @Autowired
    private IPhoneNumberService phoneNumberDao;
    @Autowired
    private IPhoneBookService phoneBookDao;


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody PhoneNumber phb, HttpSession session) {
//		PhoneBook book =  phoneBookDao.get(phb.getPhoneBook().getIdPhoneBook());
//		phb.setPhoneBook(book);
        phoneNumberDao.save(phb);
        return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody PhoneNumber phb, HttpSession session) {
//		PhoneBook book =  phoneBookDao.get(phb.getPhoneBook().getIdPhoneBook());
//		phb.setPhoneBook(book);
        phoneNumberDao.update(phb);
        return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "getAllByPhoneBook", method = RequestMethod.POST)
    public ResponseEntity<?> getall(@RequestBody PhoneBook pb, HttpSession session) {
        List<PhoneNumber> numbers = phoneNumberDao.getAllByPhoneBook(pb.getIdPhoneBook());
        return new ResponseEntity<>(numbers,
                HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "getAllPhoneNumberByPhoneBookAndAccount", method = RequestMethod.POST)
    public ResponseEntity<?> getAllPhoneNumberByPhoneBookAndAccount(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        List<PhoneNumber> numbers = phoneNumberDao.getAllPhoneNumberByPhoneBookAndAccount(account.getIdAccount());
        for (PhoneNumber phoneNumber : numbers) {
            System.out.println(phoneNumber.getIdPhone());
        }
        return new ResponseEntity<>(numbers,
                HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<?> delete(@RequestBody PhoneNumber phb) {
        if (phoneNumberDao.get(phb.getIdPhone()) == null) {
            return new ResponseEntity<>(phb, HttpStatus.BAD_REQUEST);
        } else {
            phoneNumberDao.delete(phoneNumberDao.get(phb.getIdPhone()));
            return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);
        }

    }

}
