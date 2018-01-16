package com.projet.isidis.web.service;

import com.projet.isidis.web.domaine.Commande;
import com.projet.isidis.web.domaine.Menu;
import com.projet.isidis.web.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu findOneMenu(Long id){
        /*
        JAVA 8: return sa class Si optional a une valeur
                sinon throw une exception NoSuchElementException
         */
        try {
            return this.menuRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }



}
