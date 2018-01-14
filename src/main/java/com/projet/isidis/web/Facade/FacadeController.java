package com.projet.isidis.web.Facade;

import com.projet.isidis.web.domaine.Commande;
import com.projet.isidis.web.domaine.Menu;
import com.projet.isidis.web.service.CommandeService;
import com.projet.isidis.web.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FacadeController {

    @Autowired
    private RestoService restoService;

    @Autowired
    private CommandeService commandeService;

    /*
    findeMenus : pour recuperer tous les menus dans le resto.
    parame: id est un id de resto.
    return: une list Menus
     */
    @RequestMapping("menus/{id}")
    public List<Menu> findeMenus(@PathVariable Long id){
        List<Menu> menusByResto = new ArrayList<Menu>(this.restoService.findOneResto(id).getMenus());
        for(Menu m:menusByResto)
            m.setRestomenu(null);
        return menusByResto;
    }

    /*
    enregistrerUneCommande: pour enregistrer une informations d'une commande de client
    parame: une class d'objet Commande
    return boolean: true is ok
                    false is faild
     */
    @PostMapping(value = "/menuCommande")
    public boolean enregistrerUneCommande(Commande m_commande){
        Commande commande = m_commande;
        return commandeService.commande_menu(commande);
    }
}
