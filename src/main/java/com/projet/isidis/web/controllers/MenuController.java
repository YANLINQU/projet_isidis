package com.projet.isidis.web.controllers;

import com.projet.isidis.web.domaine.Menu;
import com.projet.isidis.web.service.MenuService;
import com.projet.isidis.web.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;
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

    @RequestMapping("/menus/search/{id}")
    public Menu findOneMenu(@PathVariable Long id){
        Menu menu = menuService.findOneMenu(id);
        menu.setRestomenu(null);
        return menu;
    }

    @RequestMapping("/menus/{idMenu}/modifyActivity")
    public int menuCommandeByClient( @PathVariable Long idMenu){

        return this.menuService.modifyActivity(idMenu);
    }
}
