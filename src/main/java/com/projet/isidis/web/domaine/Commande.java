package com.projet.isidis.web.domaine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema = "projet_isidis",name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotNull
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date datecommande;
    @Column(columnDefinition="Decimal(5,2) default '0.00'")
    private float montant;
    @Column
    private boolean paiement;
    @Column
    private boolean valider;
    @Column
    private int id_client;

    //@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="id_table")
    //private Tables idtable;
    @Column
    private int id_table;

/*
    @OneToMany(mappedBy="idcommande",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<CommandeDetaille> commandes_detaille = new HashSet<CommandeDetaille>();
    public void addCommande_detaille(CommandeDetaille commande_detaille){ this.commandes_detaille.add(commande_detaille); }
    public Set<CommandeDetaille> getCommandes_detaille(){ return this.commandes_detaille; }
    public void setCommandes_detaille(Set<CommandeDetaille> commandes){ this.commandes_detaille=commandes_detaille; }
*/
    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatecommande() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(datecommande);
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
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

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }
}
