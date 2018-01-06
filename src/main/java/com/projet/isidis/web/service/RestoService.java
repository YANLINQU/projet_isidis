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

    public Resto findOneResto(Long id){
        return this.restoRepository.findById(id).get();
    }

    public List<Resto> findAllRestoByRestaurateur(Restaurateur restaurateur){
        Resto resto = new Resto();
        resto.setIdrestaurateur(restaurateur);
        Example<Resto> restos = Example.of(resto);
        return convert(restoRepository.findAll(restos));
    }

    public List<Resto> convert(Iterable<Resto> restaurateurs){
        List<Resto> restaurateurList = new ArrayList<Resto>();
        restaurateurs.forEach(restaurateurList::add);
        return restaurateurList;
    }
}
