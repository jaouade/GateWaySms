package com.sms.restController;

import com.sms.entities.Account;
import com.sms.entities.SmsTemplate;
import com.sms.service.ISmsTemplateService;
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
@RequestMapping("smsTemplate")
public class RestSmsTemplate {
    private Logger log = Logger.getLogger(RestSmsTemplate.class);

    @Autowired
    private ISmsTemplateService smsTemplateDao;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SmsTemplate smsTemplate, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        smsTemplate.setAccount(account);
        smsTemplateDao.save(smsTemplate);
        return new ResponseEntity<>(smsTemplate, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody SmsTemplate smsTemplate, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        smsTemplate.setAccount(account);
        smsTemplateDao.update(smsTemplate);
        return new ResponseEntity<>(smsTemplate, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public ResponseEntity<?> getall(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        List<SmsTemplate> liSmsTemplates = smsTemplateDao.getAllByAccount(account);
        return new ResponseEntity<>(liSmsTemplates, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<?> delete(@RequestBody SmsTemplate st) {
        if (smsTemplateDao.get(st.getIdSmsTemplate()) == null) {
            return new ResponseEntity<>(st, HttpStatus.BAD_REQUEST);
        } else {
            smsTemplateDao.delete(smsTemplateDao.get(st.getIdSmsTemplate()));
            return new ResponseEntity<>(st, HttpStatus.ACCEPTED);
        }

    }

}
