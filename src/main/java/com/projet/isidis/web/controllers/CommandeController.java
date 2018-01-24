package com.projet.isidis.web.controllers;

import com.projet.isidis.web.domaine.Commande;
import com.projet.isidis.web.domaine.Menu;
import com.projet.isidis.web.domaine.Restaurateur;
import com.projet.isidis.web.domaine.Tables;
import com.projet.isidis.web.service.CommandeService;
import com.projet.isidis.web.service.MenuService;
import com.projet.isidis.web.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private CommandeService commandeService;

    @RequestMapping("commande/{id}")
    public List<Commande> menuCommande(){
        return commandeService.findAllCommandes();
    }


    @RequestMapping("commandeMenu/{id}/{id_menu}")
    public boolean menuCommande(@PathVariable Long id,@PathVariable Long id_menu){
        System.out.println("id_table:"+id+"  id_menu:"+id_menu);
        Menu menu = menuService.findOneMenu(id_menu);
        Commande commande = new Commande();
        commande.setId_client(1);
        commande.setId_menu(id_menu.intValue());
        commande.setId_table(id.intValue());
        commande.setMontant(Float.valueOf(menu.getPrix()));
        commande.setPaiement(false);
        commande.setValider(false);
        Date today = new Date();
        commande.setDatecommande(today);
        return commandeService.commande_menu(commande);
    }
    /*
    public List<Commande> menuCommande(@PathVariable Long id){
        System.out.println("Hello Menus!");
        List<Tables> tablesByResto = new ArrayList<Tables>(this.restoService.findOneResto(id).getTables());
        List<Commande> commandesByResto = new ArrayList<Commande>();
        for(Tables t:tablesByResto){
            commandesByResto.addAll(new ArrayList<Commande>(t.getCommandes()));
        }
        for(Commande c:commandesByResto){
            c.setIdtable(null);
            System.out.println("datecommande:"+c.getDatecommande());
        }
        return commandesByResto;
    }
    */
}
