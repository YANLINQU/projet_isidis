package com.projet.isidis.web.controllers;

import com.projet.isidis.web.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController {

    @Autowired
    private RestoService restoService;
    /*
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
    */
}
