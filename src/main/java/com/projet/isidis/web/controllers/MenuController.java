package com.projet.isidis.web.controllers;

import com.projet.isidis.web.domaine.Menu;
import com.projet.isidis.web.service.MenuService;
import com.projet.isidis.web.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private RestoService restoService;

    @RequestMapping("menus/{id}")
    public List<Menu> findeMenus(@PathVariable Long id){
        System.out.println("Hello Menus!");
        List<Menu> menusByResto = new ArrayList<Menu>(this.restoService.findOneResto(id).getMenus());
        for(Menu m:menusByResto){
            m.setRestomenu(null);
            System.out.println("Nomme:"+m.getNomme());
        }
        return menusByResto;
    }
}
