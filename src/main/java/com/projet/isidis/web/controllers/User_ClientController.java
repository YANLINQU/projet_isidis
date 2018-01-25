package com.projet.isidis.web.controllers;

import com.projet.isidis.web.domaine.User_Client;
import com.projet.isidis.web.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User_ClientController {
    @Autowired
    private ClientsService clientsService;

    @RequestMapping("userLogin/{name}/{pwd}")
    public User_Client menuCommande(@PathVariable String name, @PathVariable String pwd){
        //System.out.println("name:"+name+"  pwd:"+pwd);
        User_Client user_client = clientsService.findOneUserByNamePwd(name,pwd);
        if(user_client != null)
            return user_client;
        else
            return null;
    }
}
