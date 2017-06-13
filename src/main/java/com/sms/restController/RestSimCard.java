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

import com.sms.dao.ISimCardDao;
import com.sms.entities.SimCard;

@RestController
@RequestMapping("simcard")
public class RestSimCard {
    private Logger log = Logger.getLogger(RestSimCard.class);

    @Autowired
    @Qualifier("simcarddao")
    private ISimCardDao simCardDao;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SimCard phb, HttpSession session) {

        return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "getOne", method = RequestMethod.POST)
    public ResponseEntity<?> get(@RequestBody SimCard phb, HttpSession session) {

        SimCard book = simCardDao.get(phb.getIdSimCard());
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody SimCard phb, HttpSession session) {
//		Account account = (Account)session.getAttribute("account");
//		phb.setAccount(account);
//		simCardDao.update(phb);
        return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public ResponseEntity<?> getall(HttpSession session) {
        List<SimCard> simcards = simCardDao.getAll();
        return new ResponseEntity<>(simcards,
                HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<?> delete(@RequestBody SimCard phb) {
        if (simCardDao.get(phb.getIdSimCard()) == null) {
            return new ResponseEntity<>(phb, HttpStatus.BAD_REQUEST);
        } else {
            simCardDao.delete(simCardDao.get(phb.getIdSimCard()));
            return new ResponseEntity<>(phb, HttpStatus.ACCEPTED);
        }

    }

}
