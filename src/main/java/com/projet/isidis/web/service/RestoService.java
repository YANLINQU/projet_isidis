package com.projet.isidis.web.service;

import com.projet.isidis.web.domaine.Restaurateur;
import com.projet.isidis.web.domaine.Resto;
import com.projet.isidis.web.repositories.RestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestoService {
    @Autowired
    private RestoRepository restoRepository;

    /*
    chercher un Resto pas son id
     */
    public Resto findOneResto(Long id){
        return this.restoRepository.findById(id).get();
    }

    /*
    chercher Tous les restaurants appartenant au restaurateur
     */
    public List<Resto> findAllRestoByRestaurateur(Restaurateur restaurateur){
        Resto resto = new Resto();
        resto.setIdrestaurateur(restaurateur);
        Example<Resto> restos = Example.of(resto);
        return convert(restoRepository.findAll(restos));
    }

    /*
    modifier le type Iterable des resto en une liste
     */
    public List<Resto> convert(Iterable<Resto> restaurateurs){
        List<Resto> restaurateurList = new ArrayList<Resto>();
        restaurateurs.forEach(restaurateurList::add);
        return restaurateurList;
    }
}
