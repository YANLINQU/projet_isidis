package com.projet.isidis.web.controllers;

import com.projet.isidis.web.domaine.*;
import com.projet.isidis.web.service.ClientsService;
import com.projet.isidis.web.service.CommandeService;
import com.projet.isidis.web.service.MenuService;
import com.projet.isidis.web.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
cette classe est un contrecollé Web Service
 */
@RestController
public class CommandeController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private ClientsService clientsService;

    /*
    Auteur : Yanlin Qu
    GET request
    Chercher toutes les commandes par l'id de Resto
    id: l'id de Resto
     */
    @RequestMapping("commande/{id}")
    public List<Commande> menuCommande(){
        return commandeService.findAllCommandes();
    }


    /*
    Auteur : Yanlin Qu
    POST request
    Enregistrer une commande quand le client presse le bouton commande.
    id_table: l'id de la table dans un Resto
    id_client: l'id de client de la commande
    id_menu: l'id de menu que le client commande

     */
    @RequestMapping("/commandeMenu")
    public boolean menuCommandeByClient( String id_table,
                                         String id_client,
                                         String id_menu){
        //System.out.println("id_table:" + id_table + " id_client:" + id_client + " id_menu:" + id_menu);
        Menu menu = this.menuService.findOneMenu(Long.valueOf(id_menu));
        User_Client client = this.clientsService.findOneById(Long.valueOf(id_client));
        Commande commande = new Commande();
        commande.setDatecommande(new Date());
        commande.setValider(false);
        commande.setPaiement(false);
        commande.setMontant(menu.getPrix());
        commande.setId_table(Integer.valueOf(id_table));
        commande.setMenu_name(menu.getNomme());
        commande.setClientID(client.getId());
        this.commandeService.save(commande);
        return true;
    }

    /*
    Auteur : Yanlin Qu
    GET request
    cette fonction pour tester une commande par une request GET
    id_table: l'id de la table dans un Resto
    id_client: l'id de client de la commande
    id_menu: l'id de menu que le client commande
     */
    @RequestMapping("commandeMenu/{id_table}/{id_menu}/{id_client}")
    public boolean menuCommandeByClientBySoap(@PathVariable String id_table,
                                              @PathVariable String id_menu,
                                              @PathVariable String id_client){
        //System.out.println("name:"+name+"  pwd:"+pwd);
        //System.out.println("id_table:" + id_table + " id_client:" + id_client + " id_menu:" + id_menu);
        Menu menu = this.menuService.findOneMenu(Long.valueOf(id_menu));
        Commande commande = new Commande();
        commande.setDatecommande(new Date());
        commande.setValider(false);
        commande.setPaiement(false);
        commande.setMontant(menu.getPrix());
        commande.setId_table(Integer.valueOf(id_table));
        commande.setMenu_name(menu.getNomme());
        commande.setClientID(Long.parseLong(id_client));
        this.commandeService.save(commande);
        return true;
    }

    @RequestMapping("Client/{id_client}/{id_table}/{id_menu}/commande")
    public boolean clientCommandeByClientBySoap(@PathVariable String id_table,
                                              @PathVariable String id_menu,
                                              @PathVariable String id_client){
        //System.out.println("name:"+name+"  pwd:"+pwd);
        System.out.println("id_table:" + id_table + " id_client:" + id_client + " id_menu:" + id_menu);
        Menu menu = this.menuService.findOneMenu(Long.valueOf(id_menu));
        Commande commande = new Commande();
        commande.setDatecommande(new Date());
        commande.setValider(false);
        commande.setPaiement(false);
        commande.setMontant(menu.getPrix());
        commande.setId_table(Integer.valueOf(id_table));
        commande.setMenu_name(menu.getNomme());
        commande.setClientID(Long.parseLong(id_client));
        this.commandeService.save(commande);
        return true;
    }

}
