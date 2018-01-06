package com.projet.isidis.web.domaine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "projet_isidis",name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int id;
    @NotNull
    @Size(min=1, max=50)
    @Column
    private String nomme;
    @NotNull
    @Size(min=1, max=255)
    @Column
    private String imageadresse;
    @Column(columnDefinition="Decimal(5,2) default '0.00'")
    private float prix;
    @NotNull
    @Size(min=1, max=1000)
    @Column
    private String description;
    @Column
    private boolean activite;
    /*
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_restaurateur")
    private int restomenu;

    @OneToMany(mappedBy="idmenu",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<CommandeDetaille> commandes_detaille = new HashSet<CommandeDetaille>();
    public void addCommande_detaille(CommandeDetaille commande_detaille){ this.commandes_detaille.add(commande_detaille); }
    public Set<CommandeDetaille> getCommandes_detaille(){ return this.commandes_detaille; }
    public void setCommandes_detaille(Set<CommandeDetaille> commandes_detaille){ this.commandes_detaille=commandes_detaille; }
*/
    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomme() {
        return nomme;
    }

    public void setNomme(String nomme) {
        this.nomme = nomme;
    }

    public String getImageadresse() {
        return imageadresse;
    }

    public void setImageadresse(String imageadresse) {
        this.imageadresse = imageadresse;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActivite() {
        return activite;
    }

    public void setActivite(boolean activite) {
        this.activite = activite;
    }

}
