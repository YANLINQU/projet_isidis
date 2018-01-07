package com.projet.isidis.web.service;

import com.projet.isidis.web.domaine.Commande;
import com.projet.isidis.web.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

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
}
