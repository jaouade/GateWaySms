package com.sms.restController;

import com.sms.dao.*;
import com.sms.entities.Account;
import com.sms.entities.Client;
import com.sms.entities.SimCard;
import com.sms.entities.Sms;
import com.sms.service.JsonService;
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

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("sms")
public class RestSMS {
    private Logger log = Logger.getLogger(RestSMS.class);

    @Autowired
    @Qualifier("smsdao")
    private ISmsDao smsdao;
    @Autowired
    @Qualifier("clientdao")
    private IClientDao cldao;
    @Autowired
    @Qualifier("accountdao")
    private IAccountDao iAccountDao;
    @Autowired
    @Qualifier("phonenumberdao")
    private IPhoneNumberDao pndao;
    @Autowired
    @Qualifier("simcarddao")
    private ISimCardDao simcarddao;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Sms sms, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        account.setSmsCredit(account.getSmsCredit() - sms.getNbMessages());
        if(account.getSmsCredit()>=0){
            SimCard card = simcarddao.get(sms.getSimCard().getIdSimCard());
            iAccountDao.update(account);
            account = iAccountDao.get(account.getIdAccount());
            sms.setAccount(account);

            sms.setSimCard(card);
            sms.setSendDate(new Date(sms.getDate()));
            smsdao.save(sms);

            return new ResponseEntity<>(new JsonService.Success("you message has been saved successfully",sms), ACCEPTED);
        }else{
            return new ResponseEntity<>(new JsonService.Error("we can't save your message you don't have enough credits",sms), NOT_FOUND);
        }


    }

    @RequestMapping(value = "getOne", method = RequestMethod.POST)
    public ResponseEntity<?> get(@RequestBody Sms sms) {

        sms = smsdao.get(sms.getIdSms());
        return new ResponseEntity<>(sms, ACCEPTED);

    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody Sms phb, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        phb.setAccount(account);
        smsdao.update(phb);
        return new ResponseEntity<>(phb, ACCEPTED);
    }

    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public ResponseEntity<?> getall(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        List<Sms> books = smsdao.getAll();
        return new ResponseEntity<>(books,
                ACCEPTED);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<?> delete(@RequestBody Sms phb) {
        if (smsdao.get(phb.getIdSms()) == null) {
            return new ResponseEntity<>(phb, HttpStatus.BAD_REQUEST);
        } else {
            smsdao.delete(smsdao.get(phb.getIdSms()));
            return new ResponseEntity<>(phb, ACCEPTED);
        }

    }

}
