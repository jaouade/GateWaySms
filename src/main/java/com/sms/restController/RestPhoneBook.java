package com.sms.restController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dao.IPhoneBookDao;
import com.sms.entities.Account;
import com.sms.entities.PhoneBook;

@RestController
@RequestMapping("phoneBook")
public class RestPhoneBook {
    private Logger log = Logger.getLogger(RestPhoneBook.class);

    @Autowired
    @Qualifier("phonebookdao")
    private IPhoneBookDao phoneBookDao;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody PhoneBook phb, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        phb.setAccount(account);
        System.out.println(phb.getBookName());
        phoneBookDao.save(phb);
        return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "getOne", method = RequestMethod.POST)
    public ResponseEntity<?> get(@RequestBody PhoneBook phb, HttpSession session) {

        PhoneBook book = phoneBookDao.get(phb.getIdPhoneBook());
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody PhoneBook phb, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        phb.setAccount(account);
        phoneBookDao.update(phb);
        return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public ResponseEntity<?> getall(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        List<PhoneBook> books = phoneBookDao.getAllByAccount(account);
        return new ResponseEntity<>(books,
                HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<?> delete(@RequestBody PhoneBook phb) {
        if (phoneBookDao.get(phb.getIdPhoneBook()) == null) {
            return new ResponseEntity<>(phb, HttpStatus.BAD_REQUEST);
        } else {
            phoneBookDao.delete(phoneBookDao.get(phb.getIdPhoneBook()));
            return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);
        }

    }

}
