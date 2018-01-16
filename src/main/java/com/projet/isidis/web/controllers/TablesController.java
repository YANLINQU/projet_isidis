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
    private RestoService restoService;
    @Autowired
    private TablesService tablesService;

    @RequestMapping("tables/{id}")
    public List<Tables> findeTables(@PathVariable Long id){
        //List<Tables> tablesByResto = new ArrayList<Tables>(this.restoService.findOneResto(id).getTables());
        List<Tables> tablesByResto = tablesService.findAllTables();
        for(Tables t:tablesByResto){
            t.setIdresto(null);
            //t.setCommandes(null);
        }
        return tablesByResto;
    }

}
