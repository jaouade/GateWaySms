package com.sms.controller;

import com.sms.dao.IAccountDao;
import com.sms.dao.ITokenDao;
import com.sms.entities.*;
import com.sms.service.ISectorService;
import com.sms.service.IcityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Objects;

@Controller
public class IndexController {
    Logger logger = Logger.getLogger(IndexController.class);
    @Autowired
    private IcityService cityDao;
    @Autowired
    private ITokenDao tokenDao;
    @Autowired
    private ISectorService secDao;
    @Autowired
    private IAccountDao acDao;

    @ModelAttribute("account")
    public Account account() {
        return new Account();
    }

    @RequestMapping(value = "/sms_app")
    public String clientLo() {
        return "home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=1";
    }
    @RequestMapping(value = "/activateMyAccount/{token}", method = RequestMethod.GET)
    public String activateMyAccount(@PathVariable String token,HttpServletRequest request, HttpServletResponse response) {
        Token tok= tokenDao.getTokenByToken(token);
        if(Objects.nonNull(tok)){
            Account account =  acDao.getAcountByLogin(tok.getEmail());
            if(Objects.nonNull(account)) {
                account.setState(true);
                acDao.update(account);
                return "activated";
            }else {
                return "doesnotexist";
            }
        }else {
            return "doesnotexist";
        }

    }
    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    public String activate(ModelMap map, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //map.addAttribute("email",session.getAttribute("email"));
        if (auth != null) new SecurityContextLogoutHandler().logout(request, response, auth);
        return "activate";
    }
    @RequestMapping(method = RequestMethod.GET, value = "index")
    public String home(Principal principal, HttpSession session) {
        String name = principal.getName();
        Account account = acDao.getAcountByLogin(name);
        session.setAttribute("account", account);
        if(!account.getCredential().getRole().equals("Role_Admin")){
            logger.info(account.getState());
            if(!account.getState()){
                session.setAttribute("email", account.getClient().getEmail());
                return "redirect:/activate";
            }
            return "index";
        }else{
            return "404";
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "signup")
    public String createAccount() {
        return "create-account";
    }

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "signup")
    public String postSignup(@ModelAttribute("account") Account account, BindingResult bindingResult, Model model) {
        City city = cityDao.get(account.getClient().getCity().getIdCity());
        Sector sector = secDao.get(account.getClient().getSector().getIdSector());
        com.sms.entities.Client client = account.getClient();
        client.setCity(city);
        client.setSector(sector);
        Credential credential = account.getCredential();
        credential.setRole("Role_User");
        account.setClient(client);
        account.setCredential(credential);
        logger.info(acDao.save(account));

        return "redirect:home";
    }

}
