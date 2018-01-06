package com.projet.isidis.web.controllers;


import com.projet.isidis.web.domaine.Tables;
import com.projet.isidis.web.service.RestoService;
import com.projet.isidis.web.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TablesController {
    @Autowired
    private TablesService tablesService;
    @Autowired
    private RestoService restoService;

    @RequestMapping("/table/{id}")
    public List<Tables> index(@PathVariable Long id){
        return this.tablesService.findAllTablesByResto(this.restoService.findOneResto(id));
    }
}
