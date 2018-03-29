package com.projet.isidis.web.menusoap;

import com.projet.isidis.web.domaine.Menu;
import com.projet.isidis.web.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MenusRepository {

    @Autowired
    private RestoService restoService;

    @PostConstruct
    public void initData(){

    }

    public RestoMenusType findAllMenus(Long id,String id_table){
        List<Menu> menusByResto = new ArrayList<Menu>(this.restoService.findOneResto(id).getMenus());
        for(Menu m:menusByResto)
            m.setRestomenu(null);
        String restoName = this.restoService.findOneResto(id).getNom();

        RestoMenusType restoType = new RestoMenusType();
        restoType.setTablecommande(id_table);
        restoType.setName(restoName);

        MenusAllType menusType = new MenusAllType();

        for(Menu m:menusByResto){
            MenusType menutype = new MenusType();
            menutype.setIdMenu(String.valueOf(m.getId()));
            menutype.setNomme(m.getNomme());
            menutype.setImage(m.getImageadresse());
            menutype.setPrix(String.valueOf(m.getPrix()));
            menusType.getMenus().add(menutype);
        }
        restoType.setMenusAll(menusType);
        return restoType;
    }
}
