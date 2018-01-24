package com.projet.isidis.web.menusoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MenuSoapEndpoint {
    private static final String NAMESPACE_URI = "http://iaws/resto/menus/projet";

    private MenusRepository menusRepository;

    @Autowired
    public MenuSoapEndpoint(MenusRepository menusRepository) {
        this.menusRepository = menusRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MenusRequest")
    @ResponsePayload
    public RestoMenusType getMenus(@RequestPayload MenusRequest request) {
        System.out.println("Recu SOAP!");
        RestoMenusType response = menusRepository.findAllMenus(Long.valueOf("1"),request.getIdTable());
        return response;
    }
}
