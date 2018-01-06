package com.projet.isidis.web.domaine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(schema = "projet_isidis",name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int id;
    @NotNull
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;
    @Column(columnDefinition="Decimal(5,2) default '0.00'")
    private float montant;
    @Column
    private boolean paiement;
    @Column
    private boolean valider;
    private int client;

/*
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_table")
    private int idtable;

    @OneToMany(mappedBy="idcommande",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<CommandeDetaille> commandes_detaille = new HashSet<CommandeDetaille>();
    public void addCommande_detaille(CommandeDetaille commande_detaille){ this.commandes_detaille.add(commande_detaille); }
    public Set<CommandeDetaille> getCommandes_detaille(){ return this.commandes_detaille; }
    public void setCommandes_detaille(Set<CommandeDetaille> commandes){ this.commandes_detaille=commandes_detaille; }
*/
    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public boolean isPaiement() {
        return paiement;
    }

    public void setPaiement(boolean paiement) {
        this.paiement = paiement;
    }

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

}
