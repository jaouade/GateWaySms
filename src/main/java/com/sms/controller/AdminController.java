package com.sms.controller;

import com.sms.entities.*;
import com.sms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private ISimCardService iSimCardDao;
    @Autowired
    private ILogHistoryService iLogHistoryService;
    @Autowired
    private ISmsPriceService iSmsPriceService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private ICommandService iCommandService;
    @Autowired
    private ISimCardService iSimCardService;
    @ModelAttribute("card")

    public SimCard card() {
        return new SimCard();
    }

    @ModelAttribute("smsprice")

    public SmsPrice smsprice() {
        return new SmsPrice();
    }

    @RequestMapping(value = "/home")
    public String adminHome() {
        return "admin";
    }

    @RequestMapping(value="/cartedisp")
    public ModelAndView CarteDisponile(){
        Map<String ,Object> model = new HashMap<>();
        model.put("AllsimCards",  iSimCardDao.getAll());
        return new ModelAndView("carteDISPO", model);
    }

    //A enlever
    @RequestMapping(value="/ajoutSim",  method = RequestMethod.POST)
    public ModelAndView AjouterCarteSIM(@ModelAttribute("card") SimCard card, BindingResult result){
        card.setCreditSms(0);
        card.setTreshold(22);
        card.setActivationDate(null);
        iSimCardDao.save(card);
        return new ModelAndView("redirect:/admin/cartedisp");
    }

    //A enlever
    @RequestMapping(value="/supSim/{id}",  method = RequestMethod.GET)
    public ModelAndView SuprimerCarteSIM(@ModelAttribute("card") SimCard card, @PathVariable long id, BindingResult result){
        iSimCardDao.delete(iSimCardDao.get(id));
        return new ModelAndView("redirect:/admin/cartedisp");
    }

    @RequestMapping(value="/cartedemande")
    public ModelAndView DemandeCarteSIM(){
        Map<String ,Object> model = new HashMap<>();
        List<Command> AllDemandesSIM = iCommandService.getAll();
        ListIterator<Command> lo = AllDemandesSIM.listIterator();
        while (lo.hasNext()) {
            Command x = lo.next();
            if (x.getConfirmed() == 1) {
                lo.remove();
            }
        }
        model.put("AlldemandesSIM", AllDemandesSIM);
        return new ModelAndView("demandeSIM", model);
    }

    @RequestMapping(value = "/verifSIM/{id}", method = RequestMethod.GET)
    public ModelAndView VerificationDispoSIM(@ModelAttribute("card") SimCard card, @PathVariable long id, BindingResult result) {
        Map<String, Object> model = new HashMap<>();
        List<SimCard> AllSIM = iSimCardService.getAll();
        Command xo = iCommandService.get(id);         // iSimCardDao --> dao de la nouvelle base
        boolean test = true;
        for (SimCard crd : AllSIM) {
            if (xo.getNumber().equals(crd.getSimNumber())) {
                test = false;
                break;
            }
        }

        if (test) {
            SimCard newSimCard = new SimCard();
            newSimCard.setActivationDate(new Date());
            newSimCard.setCreditSms(0);
            newSimCard.setOperator("IAM");
            newSimCard.setSimNumber(xo.getNumber());
            iSimCardService.save(newSimCard);
            Account account = xo.getAccount();
            account.setSimCard(newSimCard);
            iAccountService.update(account);
        } else {
            xo.setConfirmed(2);
        }

        /**ListIterator<SimCard> lo=  AllDemandesSIM.listIterator();
         while (lo.hasNext()) {
         SimCard x = lo.next();
         //condition = demande non traitée par ADMIN
         if (x.getOperator().equals("ATT")) {
         lo.remove();
         }
         }**/
        return new ModelAndView("redirect:/admin/cartedemande");
    }

    @RequestMapping(value="/demanderecharge")
    public ModelAndView DemandeRecharge(){
        Map<String ,Object> model = new HashMap<>();
        model.put("cities",  iSimCardDao.getAll());
        return new ModelAndView("demandeSIM", model);
    }

    @RequestMapping(value="/packs")
    public ModelAndView AfficherPacks(){
        Map<String ,Object> model = new HashMap<>();
        model.put("cities",  iSimCardDao.getAll());
        return new ModelAndView("demandeSIM", model);
    }

    @RequestMapping(value = "/log/{rubrique}")
    public ModelAndView Historique(@ModelAttribute("card") SimCard card, @PathVariable String rubrique, BindingResult result) {
        Map<String ,Object> model = new HashMap<>();
        List<LogHistory> listHisto = iLogHistoryService.getAll();
        switch (rubrique) {
            case "sim":
                listHisto = Filtre(listHisto, "sim");
                model.put("listHistoriques", listHisto);
                return new ModelAndView("histoSIM", model);
            case "sms":
                listHisto = Filtre(listHisto, "sms");
                model.put("listHistoriques", listHisto);
                return new ModelAndView("histoSMS", model);
            default:

                listHisto = Filtre(listHisto, "users");
                model.put("listHistoriques", listHisto);
                return new ModelAndView("histoUSER", model);
        }
    }

    public List<LogHistory> Filtre(List<LogHistory> lst, String str) {
        ListIterator<LogHistory> lo = lst.listIterator();
        while (lo.hasNext()) {
            LogHistory x = lo.next();
            if (!str.equals(x.getCategory())) {
                lo.remove();
            }
        }
        return lst;
    }

    @RequestMapping(value = "/smsprice")
    public ModelAndView AfficherSMSprice() {
        List<SmsPrice> lst = iSmsPriceService.getAll();
        ListIterator<SmsPrice> lo = lst.listIterator();
        while (lo.hasNext()) {
            SmsPrice x = lo.next();
            if (x.getDeleted().equals("yes")) {
                lo.remove();
            }
        }
        Map<String, Object> model = new HashMap<>();
        model.put("listSmsPrice", lst);
        return new ModelAndView("smsPrice", model);
    }

    @RequestMapping(value = "/addsmsprice")
    public ModelAndView AjouterSMSprice(@ModelAttribute("smsprice") SmsPrice smsprix, BindingResult result) {
        smsprix.setDeleted("no");
        iSmsPriceService.save(smsprix);
        return new ModelAndView("redirect:/admin/smsprice");
    }

    @RequestMapping(value = "/supsmsprice/{id}", method = RequestMethod.GET)
    public ModelAndView SuprimerSmsPrice(@ModelAttribute("card") SimCard card, @PathVariable long id, BindingResult result) {
        SmsPrice xo = iSmsPriceService.get(id);
        xo.setDeleted("yes");
        iSmsPriceService.update(xo);
        return new ModelAndView("redirect:/admin/smsprice");
    }

    @RequestMapping(value="/account")
    public ModelAndView ListerComptesSup() {
        List<Account> lst = iAccountService.getAll();
        ListIterator<Account> lo = lst.listIterator();
        while (lo.hasNext()) {
            Account x = lo.next();
            if (x.getState()) {
                lo.remove();
            }
        }
        Map<String ,Object> model = new HashMap<>();
        model.put("accounts", lst);
        return new ModelAndView("adminAccounts", model);
    }

    @RequestMapping(value = "/activer/{id}", method = RequestMethod.GET)
    public ModelAndView ActiverCompte(@ModelAttribute("card") SimCard card, @PathVariable long id, BindingResult result) {
        Account xo = iAccountService.get(id);
        xo.setState(true);
        iAccountService.update(xo);
        return new ModelAndView("redirect:/admin/account");
    }
}
