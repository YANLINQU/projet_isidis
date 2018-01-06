package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.Tables;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TablesRepository extends PagingAndSortingRepository<Tables,Long>,
        QueryByExampleExecutor<Tables> {
}
