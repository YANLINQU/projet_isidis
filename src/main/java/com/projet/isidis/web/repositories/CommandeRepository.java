package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.Commande;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface CommandeRepository extends PagingAndSortingRepository<Commande,Long>,
        QueryByExampleExecutor<Commande> {

        @Query("FROM Commande c WHERE c.clientID = :clientID")
        public List<Commande> findByClientID(@Param("clientID") long clientID);
}
