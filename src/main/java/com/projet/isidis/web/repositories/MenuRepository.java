package com.projet.isidis.web.repositories;


import com.projet.isidis.web.domaine.Commande;
import com.projet.isidis.web.domaine.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface MenuRepository extends PagingAndSortingRepository<Menu,Long>,
        QueryByExampleExecutor<Menu> {

    /*
    @Query("FROM Menu m WHERE m.id_restaurant = :id_restaurant")
    public List<Menu> findMenuByRestaurantID(@Param("id_restaurant") long id_restaurant);
    */

    @Query("update Menu m set m.activite = :activite where m.id = :id")
    @Modifying
    public int modifyActivite(@Param("id")Long id, @Param("activite") boolean activite);
}

