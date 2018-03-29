package com.projet.isidis.web.controllers;


import com.projet.isidis.web.domaine.Resto;
import com.projet.isidis.web.domaine.Tables;
import com.projet.isidis.web.repositories.TablesRepository;
import com.projet.isidis.web.service.RestoService;
import com.projet.isidis.web.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TablesController {
    @Autowired
    private TablesService tablesService;
    @Autowired
    private RestoService restoService;

    /*
    GET request
    chercher toutes les tables dans un resto
    id : l'id de resto
    return : une liste tables
     */

    @RequestMapping("tables/{id}")
    public List<Tables> findeTables(@PathVariable Long id){
        Resto resto = new Resto();
        resto.setId(id);
        List<Tables> tablesByResto = tablesService.findAllTables();
        for(Tables t:tablesByResto){
            t.setIdresto(resto);
        }
        return tablesByResto;
    }

    @RequestMapping("tables/search/{id}")
    public List<Tables> findTables(@PathVariable Long id){
        Resto resto = new Resto();
        resto.setId(id);
        List<Tables> table = tablesService.findAllTablesByResto(resto);
        for(Tables t:table){
            t.setIdresto(resto);
        }
        return table;
    }


    @RequestMapping("tables/{idResto}/ajout/{nombre}")
    public void ajouterTables(@PathVariable Long idResto,@PathVariable int nombre){
        Resto resto = this.restoService.findOneResto(idResto);
        this.tablesService.ajouterTables(resto,nombre);
    }


}
