package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.Commande;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CommandeRepository extends PagingAndSortingRepository<Commande,Long>,
        QueryByExampleExecutor<Commande> {
}
