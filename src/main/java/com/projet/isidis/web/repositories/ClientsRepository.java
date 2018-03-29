package com.projet.isidis.web.repositories;

import com.projet.isidis.web.domaine.User_Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ClientsRepository extends PagingAndSortingRepository<User_Client,Long>,
        QueryByExampleExecutor<User_Client> {
}
