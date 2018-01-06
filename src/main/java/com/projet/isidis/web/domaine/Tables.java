package com.projet.isidis.web.domaine;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "projet_isidis",name = "tables")
public class Tables {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int numero;

    @Size(min=1, max=255)
    @Column
    private String qr;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_resto")
    private Resto idresto;
    /*
        @OneToMany(mappedBy="idtable",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
        private Set<Commande> commandes = new HashSet<Commande>();
        public void addCommande(Commande commande){ this.commandes.add(commande); }
        public Set<Commande> getCommandes(){ return this.commandes; }
        public void setCommandes(Set<Commande> commandes){ this.commandes=commandes; }
    */
    public Tables() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Resto getIdresto() {
        return idresto;
    }

    public void setIdresto(Resto idresto) {
        this.idresto = idresto;
    }
}
