package com.sms.controller;

import javax.servlet.http.HttpSession;

import com.sms.dao.IAccountDao;
import com.sms.dao.ITokenDao;
import com.sms.entities.Account;
import com.sms.entities.Token;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.dao.ICityDao;

import java.util.Objects;

@Controller
@RequestMapping("sub")
public class SubController {
    Logger logger = Logger.getLogger(SubController.class);
    @Autowired
    @Qualifier("citydao")
    private ICityDao cityDao;
    @Autowired
    @Qualifier("tokendao")
    private ITokenDao tokenDao;
    @Autowired
    @Qualifier("accountdao")
    private IAccountDao acDao;


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
