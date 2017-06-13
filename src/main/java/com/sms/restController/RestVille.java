package com.sms.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dao.ICityDao;
import com.sms.dao.ISectorDao;
import com.sms.entities.City;
import com.sms.entities.Sector;

@RestController
@RequestMapping("ville")
public class RestVille {

    @Autowired
    @Qualifier("citydao")
    private ICityDao cityDao;
    @Autowired
    @Qualifier("sectordao")
    private ISectorDao secDao;

    @RequestMapping(value = "/villes", method = RequestMethod.GET)
    public ResponseEntity<?> listVilles() {
        return new ResponseEntity<List<City>>(cityDao.getAll(),
                HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/sectors", method = RequestMethod.GET)
    public ResponseEntity<?> listSectors() {
        return new ResponseEntity<List<Sector>>(secDao.getAll(),
                HttpStatus.ACCEPTED);
    }


}
