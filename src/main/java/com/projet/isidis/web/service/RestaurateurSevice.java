package com.projet.isidis.web.service;


import com.projet.isidis.web.domaine.Restaurateur;
import com.projet.isidis.web.repositories.RestaurateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestaurateurSevice {
    @Autowired
    private RestaurateurRepository restaurateurRepository;

    public Restaurateur findOneRestaurateur(Long i){
        /*
        JAVA 8: return sa class Si optional a une valeur
                sinon throw une exception NoSuchElementException
         */
        try {
            return this.restaurateurRepository.findById(i).get();
        }catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public List<Restaurateur> findRestaurateurs(String email,String pwd) {
        Restaurateur patron = new Restaurateur();
        patron.setEmail(email);
        patron.setPwd(pwd);
        Example<Restaurateur> example = Example.of(patron);

        return convert(restaurateurRepository.findAll(example));
    }

    public List<Restaurateur> convert(Iterable<Restaurateur> restaurateurs){
            List<Restaurateur> restaurateurList = new ArrayList<Restaurateur>();
            restaurateurs.forEach(restaurateurList::add);
            return restaurateurList;
    }
}
