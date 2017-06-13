package com.sms.restController;

import com.sms.dao.*;
import com.sms.entities.*;
import com.sms.service.Hash;
import com.sms.service.JsonService;
import com.sms.service.MailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("client")
public class RestClient {
    private Logger log = Logger.getLogger(RestClient.class);

    @Autowired
    @Qualifier("accountdao")
    private IAccountDao accountDao;
    @Autowired
    @Qualifier("tokendao")
    private ITokenDao tokenDao;
    @Autowired
    @Qualifier("citydao")
    private ICityDao cityDao;
    @Autowired
    @Qualifier("sectordao")
    private ISectorDao secDao;
    @Autowired
    @Qualifier("rechargesimdao")
    private IRechargeSimDao rechdao;


    @Autowired
    private MailService mailS;

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody Account account) {
        Account acc = accountDao.getAcountByLogin(account.getCredential().getLogin());
        if (acc != null) {

            return new ResponseEntity<>("Utilisateur existe deja ", HttpStatus.NOT_FOUND);

        } else {
            City city = cityDao.get(account.getClient().getCity().getIdCity());
            Sector sector = secDao.get(account.getClient().getSector().getIdSector());
            com.sms.entities.Client client = account.getClient();
            client.setCity(city);
            client.setSector(sector);
            Credential credential = account.getCredential();
            credential.setRole("Role_User");
            account.setClient(client);
            account.setCredential(credential);
            account.setThreshold(30);
            account.setSmsCredit(10);
            if (accountDao.save(account) == null) {
                return new ResponseEntity<>("internal error", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
            }

        }

    }

    @RequestMapping(value = "sub-account", method = RequestMethod.POST)
    public ResponseEntity<?> subAccount(@RequestBody Token token,HttpSession session) {
        String email = token.getEmail();
        Account accountFromSession = (Account) session.getAttribute("account");
        Account acc =  accountDao.getAcountByLogin(token.getEmail());
        if(Objects.nonNull(acc)){
            return new ResponseEntity<>(new JsonService.Error("this email already exist",token), HttpStatus.NOT_FOUND);
        }else{
            acc =new Account();
            Long date = new Date().getTime();
            acc.setClient(token.getWhoCreateIt().getClient());
            acc.getClient().setIdClient(0);
            token.getWhoCreateIt().setClient(accountFromSession.getClient());
            Credential credential = new Credential(token.getEmail(),getSaltString(),"sub_account");
            credential.setEncrypted("encrypted");
            credential.setEnabled(false);
            acc.setCredential(credential);
            acc.setState(false);
            acc.setThreshold(222);
            acc.setSmsCredit(0);
            acc.setSimCard(accountFromSession.getSimCard());
            acc.getClient().setCorp_name(token.getWhoCreateIt().getClient().getCorp_name());
            acc.getClient().setSector(accountFromSession.getClient().getSector());
            token.setToken(String.format("%s__%d", new Hash.sha256().hash(email), date));
            tokenDao.save(token);
            accountDao.save(acc);
            mailS.sendEmail(email,
                    String.format("http://localhost:9000/sub/%s", token.getToken()));
            String success = String.format("we have create the account for <strong> %s </strong> <br> and we have sent him an activation mail", email);
            return new ResponseEntity<>(new JsonService.Success(success,token), HttpStatus.ACCEPTED);

        }



    }

    @RequestMapping(value = "resend", method = RequestMethod.POST)
    public ResponseEntity<?> resend(HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (Objects.isNull(email) || email.equals("")) {
            return new ResponseEntity<>(new JsonService.Error("we cannot send you the email right now \n try to resign in :)  ",null), HttpStatus.NOT_FOUND);

        } else {
            Long date = new Date().getTime();
            Token existingOne = tokenDao.getTokenByEmail(email);
            if (Objects.nonNull(existingOne)) {
                existingOne.setToken(String.format("%s__%d", new Hash.sha256().hash(email), date));
                tokenDao.update(existingOne);
                mailS.sendEmail(email,
                        String.format("http://localhost:9000/activateMyAccount/%s", existingOne.getToken()));
                return new ResponseEntity<>(new JsonService.Success("we sent you an activation email \n check your inbox for " + email,existingOne), HttpStatus.ACCEPTED);

            } else {
                Token token = new Token(String.format("%s__%d", new Hash.sha256().hash(email), date), email);
                tokenDao.save(token);
                mailS.sendEmail(email,
                        String.format("http://localhost:9000/activateMyAccount/%s", token.getToken()));
                return new ResponseEntity<>(new JsonService.Success("we sent you an activation email \n check your inbox for " + email,token), HttpStatus.ACCEPTED);

            }

        }


    }

    @RequestMapping(value = "create_sub", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Credential cred, HttpSession session) {
                Account account = (Account) session.getAttribute("thisUser");
                account.getCredential().setPassword(cred.getPassword());
                accountDao.update(account);

                return new ResponseEntity<>(account, HttpStatus.ACCEPTED);




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

    }

}
