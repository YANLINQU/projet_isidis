package com.projet.isidis.web.domaine;

import javax.persistence.*;

@Entity
@Table(schema = "projet_isidis",name = "commande_detaille")
public class CommandeDetaille {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private int quantite;

    /*
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_menu")
    private int idmenu;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_commande")
    private int idcommande;
    */
    public CommandeDetaille() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
