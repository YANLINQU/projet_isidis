package com.projet.isidis.web.controllers;


import com.projet.isidis.web.domaine.Restaurateur;
import com.projet.isidis.web.service.RestaurateurSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RestauratuerController {
    @Autowired
    private RestaurateurSevice restaurateurSevice;


    @RequestMapping("/")
    public String index(Model model){
        //System.out.println("Hello");
        Restaurateur restaurateur = restaurateurSevice.findOneRestaurateur(Long.valueOf(4));
        model.addAttribute("restaurateur",restaurateur);
        model.addAttribute("restos",restaurateur.getRestos());
        return "index";
    }

    @RequestMapping("/Client")
    public String index(){
        return "Client";
    }

}
