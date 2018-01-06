package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.Resto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface RestoRepository extends PagingAndSortingRepository<Resto,Long>,
        QueryByExampleExecutor<Resto> {
}
