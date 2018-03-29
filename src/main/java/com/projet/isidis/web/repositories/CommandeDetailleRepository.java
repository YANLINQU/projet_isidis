package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.CommandeDetaille;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CommandeDetailleRepository extends PagingAndSortingRepository<CommandeDetaille,Long>,
        QueryByExampleExecutor<CommandeDetaille> {
}
