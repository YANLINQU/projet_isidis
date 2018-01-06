package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.Menu;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface MenuRepository extends PagingAndSortingRepository<Menu,Long>,
        QueryByExampleExecutor<Menu> {
}
