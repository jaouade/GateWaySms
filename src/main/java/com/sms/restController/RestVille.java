package com.sms.restController;

import com.sms.service.ISectorService;
import com.sms.service.IcityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ville")
public class RestVille {

    @Autowired
    private IcityService cityDao;
    @Autowired
    private ISectorService secDao;

    @RequestMapping(value = "/villes", method = RequestMethod.GET)
    public ResponseEntity<?> listVilles() {
        return new ResponseEntity<>(cityDao.getAll(),
                HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/sectors", method = RequestMethod.GET)
    public ResponseEntity<?> listSectors() {
        return new ResponseEntity<>(secDao.getAll(),
                HttpStatus.ACCEPTED);
    }


}
