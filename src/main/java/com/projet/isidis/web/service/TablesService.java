package com.projet.isidis.web.service;


import com.projet.isidis.web.domaine.Resto;
import com.projet.isidis.web.domaine.Tables;
import com.projet.isidis.web.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TablesService {
    @Autowired
    private TablesRepository tablesRepository;
    /*
    chercher la table par son id
     */
    public Tables findOneTable(Long id){
        /*
        JAVA 8: return sa class Si optional a une valeur
                sinon throw une exception NoSuchElementException
         */
        try {
            return this.tablesRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    /*
    chercher toutes les tables dans un resto
     */
    public List<Tables> findAllTablesByResto(Resto resto){
        Tables table = new Tables();
        table.setIdresto(resto);
        //table.setNumero(1);
        Example<Tables> example = Example.of(table);
        Iterable<Tables> Itables=tablesRepository.findAll(example);
        for(Tables t:Itables){
            System.out.println("id:"+t.getId()+"  numero:"+t.getNumero());
        }
        return convert(Itables);
    }

    public List<Tables> convert(Iterable<Tables> tables){
        List<Tables> tablesList = new ArrayList<Tables>();
        tables.forEach(tablesList::add);
        return tablesList;
    }
}
