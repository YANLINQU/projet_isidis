package com.projet.isidis.web.service;

import com.projet.isidis.web.domaine.User_Client;
import com.projet.isidis.web.repositories.ClientsRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    /*
    chercher un client par son id
    null : il n'y a pas trouvé
     */
    public User_Client findOneById(Long id){
        /*
        JAVA 8: return sa class Si optional a une valeur
                sinon throw une exception NoSuchElementException
         */
        try {
            return this.clientsRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /*
    rajouter un client
    true : enregistrer d'réussi
    false : enregistrer faild
     */
    public boolean save(User_Client client){
            if(clientsRepository.save(client)!=null)
                return true;
            else
                return false;
    }

    /*
    chercher tous les clients
    retourner une liste clients
     */
    public List<User_Client> findAllUsers(){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return convert(clientsRepository.findAll(sort));
    }

    /*
    modifier le type Iterable des tables en une liste
     */
    public List<User_Client> convert(Iterable<User_Client> tables){
        List<User_Client> usersList = new ArrayList<User_Client>();
        tables.forEach(usersList::add);
        return usersList;
    }

    /*
    chercher un client par son nom est pwd
    null : il n'y a pas trouver
    objet : un client
     */
    public User_Client findOneUserByNamePwd(String name,String pwd){
        User_Client user_client = new User_Client();
        user_client.setNom(name);
        user_client.setPwd(pwd);
        Example<User_Client> user = Example.of(user_client);
        try {
            return this.clientsRepository.findOne(user).get();
        }catch (NoSuchElementException ex){
            //System.out.println(ex.getMessage());
            System.out.println("incorrect username or password ! username:"+name+" pwd:"+pwd);
        }
        return null;
    }


}
