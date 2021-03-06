package com.sms.restController;

import com.sms.entities.Account;
import com.sms.entities.Compagne;
import com.sms.service.ICompagneService;
import com.sms.service.JsonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("campaign")
public class RestCompaign {
    private Logger log = Logger.getLogger(RestCompaign.class);

    @Autowired
    private ICompagneService iCompagneService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Compagne compagne, HttpSession session) {
        compagne.setSendDate(new Date(compagne.getDate()));
        compagne.setAccount((Account) session.getAttribute("account"));
        log.info(compagne);
        iCompagneService.save(compagne);
        return new ResponseEntity<>(new JsonService.Success("you campaign has been save successfully", compagne), HttpStatus.ACCEPTED);

        //return new ResponseEntity<>(account, HttpStatus.ACCEPTED);


    }

    /*@RequestMapping(value = "sub-account", method = RequestMethod.POST)
    public ResponseEntity<?> subAccount(@RequestBody Token token) {
        token.setToken(getSaltString());
        if (tokenDao.save(token) == null) {

            return new ResponseEntity<>("internal error", HttpStatus.NOT_FOUND);
        } else {
            mailS.sendEmail(token.getEmail(),
                    "http://localhost:8080/smsTemplate/sub/" + token.getToken());
            return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
        }

    }

    @RequestMapping(value = "create_sub", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Credential cred, HttpSession session) {
        String token = (String) session.getAttribute("token");
        Token to = tokenDao.getTokenByToken(token);
        if (to == null) {
            return new ResponseEntity<>(cred, HttpStatus.NOT_FOUND);
        } else {
            Account account = new Account();
            to.getWhoCreateIt().getClient().setIdClient(0);
            account.setClient(to.getWhoCreateIt().getClient());
            cred.setRole("sub_account");
            account.setCredential(cred);
            account.setIdAccount(0);
            System.out.println(account.getClient());
            if (accountDao.save(account) == null) {
                return new ResponseEntity<>(cred, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
            }
        }


    }

    @RequestMapping(value = "getsubs", method = RequestMethod.POST)
    public ResponseEntity<?> getsubs(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        List<Account> accounts = accountDao.getSubs(account);
        return new ResponseEntity<>(accounts, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "addsc", method = RequestMethod.POST)
    public ResponseEntity<?> addsc(@RequestBody RechargeSim rechsim, HttpSession session) {
        rechsim.setDateRecharge(new Date());
        rechsim.setEtat(0);
        if (rechdao.save(rechsim) != null) {
            return new ResponseEntity<>(rechsim, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1abcdefghijklmnopqrstuvwxyz234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 180) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString() + "__" + new Date().getTime();
        return saltStr;

    }*/

}
