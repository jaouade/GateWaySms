package com.sms.restController;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entities.Account;

@RestController
@RequestMapping("account")
public class RestAccount {
    private Logger log = Logger.getLogger(RestAccount.class);

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<?> signin(HttpSession session) {
        Account acc = (Account) session.getAttribute("account");
        return new ResponseEntity<Account>(acc, HttpStatus.ACCEPTED);

    }

}
