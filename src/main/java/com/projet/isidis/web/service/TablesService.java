package com.projet.isidis.web.service;


import com.projet.isidis.web.QR.QRCodeFR;
import com.projet.isidis.web.domaine.Resto;
import com.projet.isidis.web.domaine.Tables;
import com.projet.isidis.web.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class TablesService {
    @Autowired
    private TablesRepository tablesRepository;

    /*
    chercher la table par son id
     */
    public Tables findOneTable(Long id){
        /*
        JAVA 8: return sa class Si optional a une valeur
                sinon throw une exception NoSuchElementException
         */
        try {
            return this.tablesRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    /*
    chercher toutes les tables dans un resto
     */
    public List<Tables> findAllTablesByResto(Resto resto){
        Tables table = new Tables();
        table.setIdresto(resto);
        //table.setNumero(1);
        Example<Tables> example = Example.of(table);
        Iterable<Tables> Itables=tablesRepository.findAll(example);

        return convert(Itables);
    }

    /*
    chercher toutes les table
     */
    public List<Tables> findAllTables(){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return convert(tablesRepository.findAll(sort));
    }

    /*
    modifier le type Iterable des table en une liste
     */
    public List<Tables> convert(Iterable<Tables> tables){
        List<Tables> tablesList = new ArrayList<Tables>();
        tables.forEach(tablesList::add);
        return tablesList;
    }


    public void ajouterTables(Resto resto,int nombre) {

        Set<Tables> listeTables = resto.getTables();
        System.out.println(listeTables);
        int nbTableResto = listeTables.size();

        for (int i =1;i<=nombre;i++){
            int numTable = i+nbTableResto;
            QRCodeFR qrcode = new QRCodeFR();
            String qrPath = qrcode.construireQR(Integer.toString(numTable),numTable);
            Tables table = new Tables(numTable,qrPath);
            resto.addTable(table);
            tablesRepository.save(table);
        }
    }

}
