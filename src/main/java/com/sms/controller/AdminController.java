package com.sms.controller;

import com.sms.dao.ISimCardDao;
import com.sms.entities.Account;
import com.sms.entities.SimCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    @Qualifier("simcarddao")
    private ISimCardDao iSimCardDao;

    @ModelAttribute("card")
    public SimCard card() {
        return new SimCard();
    }

    @RequestMapping(value = "/home")
    public String adminHome() {
        return "admin";
    }

    @RequestMapping(value="/cartedisp")
    public ModelAndView CarteDisponile(){
        Map<String ,Object> model = new HashMap<>();

        /**List<SimCard> simCardList = iSimCardDao.getAll();
        ListIterator<SimCard> lo=  simCardList.listIterator();
        while (lo.hasNext()) {
            SimCard x = lo.next();
            if (!dv.getEtatDV().equals("ATT")) {
                lo.remove();
            }
        }**/
        model.put("AllsimCards",  iSimCardDao.getAll());
        return new ModelAndView("carteDISPO", model);
    }

    @RequestMapping(value="/ajoutSim",  method = RequestMethod.POST)
    public ModelAndView AjouterCarteSIM(@ModelAttribute("card") SimCard card, BindingResult result){
            card.setCreditSms(0);
            card.setTreshold(22);
            card.setActivationDate(null);
            iSimCardDao.save(card);
            return new ModelAndView("redirect:/admin/cartedisp");
    }

    @RequestMapping(value="/supSim/{id}",  method = RequestMethod.GET)
    public ModelAndView SuprimerCarteSIM(@ModelAttribute("card") SimCard card, @PathVariable long id, BindingResult result){
        iSimCardDao.delete(iSimCardDao.get(id));
        return new ModelAndView("redirect:/admin/cartedisp");
    }

    @RequestMapping(value="/cartedemande")
    public ModelAndView DemandeCarteSIM(){
        Map<String ,Object> model = new HashMap<>();
        model.put("cities",  iSimCardDao.getAll());
        return new ModelAndView("demandeSIM", model);
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

    @RequestMapping(value="/log")
    public ModelAndView Historique(){
        Map<String ,Object> model = new HashMap<>();
        model.put("cities",  iSimCardDao.getAll());
        return new ModelAndView("demandeSIM", model);
    }

    @RequestMapping(value="/account")
    public ModelAndView GestionComptes(){
        Map<String ,Object> model = new HashMap<>();
        model.put("cities",  iSimCardDao.getAll());
        return new ModelAndView("demandeSIM", model);
    }
}
