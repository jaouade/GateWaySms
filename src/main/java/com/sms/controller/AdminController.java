package com.sms.controller;

import com.sms.dao.ICityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    @Qualifier("citydao")
    private ICityDao cityDao;
    @RequestMapping(value = "/home")
    public String adminHome() {
        return "admin";
    }

    @RequestMapping(value="/recharges")
    public ModelAndView recharges(){
        Map<String ,Object> model = new HashMap<>();
        model.put("cities",  cityDao.getAll());
        return new ModelAndView("admin", model);
    }

}
