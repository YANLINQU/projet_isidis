package com.projet.isidis.web.service;

import com.projet.isidis.web.domaine.Commande;
import com.projet.isidis.web.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    /*
    chercher un menu par son id
     */
    public Commande findOneMenu(Long id){
        /*
        JAVA 8: return sa class Si optional a une valeur
                sinon throw une exception NoSuchElementException
         */
        try {
            return this.commandeRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /*
    rajouter un commune
     */
    public void save(Commande commande){
        commandeRepository.save(commande);
    }

    /*
    chercher toutes les commandes
    retourner une liste commandes
     */
    public List<Commande> findAllCommandes(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return convert(this.commandeRepository.findAll(sort));
    }

    /*
    chercher toutes les commandes d'un client par son id
     */
    public List<Commande> findAllCommandesByClientId(long id){
        return this.commandeRepository.findByClientID(id);
    }

    public boolean commande_menu(Commande commande){
        if(commandeRepository.save(commande)!=null)
            return true;
        else
            return false;
    }

    /*
    modifier le type Iterable des commandes en une liste
     */
    public List<Commande> convert(Iterable<Commande> commandeIterable){
        List<Commande> commandeList = new ArrayList<Commande>();
        commandeIterable.forEach(commandeList::add);
        return commandeList;
    }
}
