package com.sms.restController;

import com.sms.service.ISectorService;
import com.sms.service.IcityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ville")
@ComponentScan("com.sms.service")
public class RestVille {

    @Autowired
    private IcityService icityService;
    @Autowired
    private ISectorService secDao;

    @RequestMapping(value = "/villes", method = RequestMethod.GET)
    public ResponseEntity<?> listVilles() {
        return new ResponseEntity<>(icityService.getAll(),
                HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/sectors", method = RequestMethod.GET)
    public ResponseEntity<?> listSectors() {
        return new ResponseEntity<>(secDao.getAll(),
                HttpStatus.ACCEPTED);
    }


}
