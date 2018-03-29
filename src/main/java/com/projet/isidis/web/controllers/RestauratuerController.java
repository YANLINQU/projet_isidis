package com.projet.isidis.web.controllers;


import com.projet.isidis.web.domaine.Menu;
import com.projet.isidis.web.domaine.Restaurateur;
import com.projet.isidis.web.service.RestaurateurSevice;
import com.projet.isidis.web.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class RestauratuerController {
    @Autowired
    private RestaurateurSevice restaurateurSevice;
    @Autowired
    private RestoService restoService;


    /*
    entrer la page index sans paramètre et
    retourner deux attributes à la page index
    restaurateur : un objet restaurateur
    restos : Tous les restaurants appartenant au restaurateur
     */
    @RequestMapping("/")
    public String index(Model model){
        //web serveur
        //Restaurateur restaurateur = restaurateurSevice.findOneRestaurateur(Long.valueOf(1));
        //local
        Restaurateur restaurateur = restaurateurSevice.findOneRestaurateur(Long.valueOf(1));
        model.addAttribute("restaurateur",restaurateur);
        model.addAttribute("restos",restaurateur.getRestos());
        return "index";
    }

/*
    @RequestMapping("Menus/{id}")
    public String Menus(@PathVariable Long id, Model model){
        //System.out.println("menus soap commande");
        //web
        //List<Menu> menusByResto = new ArrayList<Menu>(this.restoService.findOneResto(Long.valueOf(3)).getMenus());
        //local
        List<Menu> menusByResto = new ArrayList<Menu>(this.restoService.findOneResto(Long.valueOf(1)).getMenus());
        for(Menu m:menusByResto){
            m.setImageadresse("../"+m.getImageadresse());
            m.setRestomenu(null);
            //System.out.println("Nomme:"+m.getNomme());
        }
        model.addAttribute("listMenus", menusByResto);

        model.addAttribute("idtable", id);
        return "Menus";
    }
    */
}
