package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface TablesRepository extends PagingAndSortingRepository<Tables,Long>,
        QueryByExampleExecutor<Tables> {



}
