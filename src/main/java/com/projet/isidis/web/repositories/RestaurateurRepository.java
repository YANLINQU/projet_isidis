package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.Restaurateur;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface RestaurateurRepository extends PagingAndSortingRepository<Restaurateur,Long>,
        QueryByExampleExecutor<Restaurateur> {
}
