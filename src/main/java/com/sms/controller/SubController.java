package com.sms.controller;

import com.sms.entities.Account;
import com.sms.entities.Token;
import com.sms.service.IAccountService;
import com.sms.service.ITokenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("sub")
public class SubController {
    Logger logger = Logger.getLogger(SubController.class);
    @Autowired
    private ITokenService tokenDao;
    @Autowired
    private IAccountService acDao;


    @RequestMapping(value = "/{token}", method = RequestMethod.GET)
    public String postSignup(@PathVariable String token, HttpSession session) {
        Token tok= tokenDao.getTokenByToken(token);
        if(Objects.nonNull(tok)){
            Account account =  acDao.getAcountByLogin(tok.getEmail());
            if(Objects.nonNull(account)) {
                account.setState(true);
                acDao.update(account);
                session.setAttribute("thisUser",account);
                return "sub";
            }else {
                return "doesnotexist";
            }
        }else {
            return "doesnotexist";
        }




    }

}
