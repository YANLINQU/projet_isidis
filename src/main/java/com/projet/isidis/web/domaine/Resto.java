package com.projet.isidis.web.domaine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema="projet_isidis",name="resto")
public class Resto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotNull
    @Size(min=1, max=50)
    @Column
    private String nom;
    @NotNull
    @Size(min=1, max=150)
    @Column
    private String adresse;
    @NotNull
    @Size(min=1, max=20)
    @Column
    private String ville;
    @NotNull
    @Size(min=1, max=10)
    @Column
    private String postal;

    @Column(columnDefinition="Decimal(5,2) default '0.00'")
    private float revenu;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_restaurateur")
    private Restaurateur idrestaurateur;

    @OneToMany(mappedBy="idresto",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Tables> tables = new HashSet<Tables>();

    public void addTable(Tables table){
        this.tables.add(table);
        table.setIdresto(this);
    }

    public Set<Tables> getTables(){ return this.tables; }
    public void setTables(Set<Tables> tables){
        this.tables=tables;
        for(Tables t : tables){
            t.setIdresto(this);
        }
    }

    @OneToMany(mappedBy="restomenu",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Menu> menus = new HashSet<Menu>();

    public void addMenu(Menu menu){
        this.menus.add(menu);
        menu.setRestomenu(this);
    }
    public Set<Menu> getMenus(){ return this.menus;}
    public void setMenus(Set<Menu> menus){
        this.menus=menus;
        for(Menu m : menus){
            m.setRestomenu(this);
        }
    }

    public Resto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public float getRevenu() {
        return revenu;
    }

    public void setRevenu(float revenu) {
        this.revenu = revenu;
    }

    public Restaurateur getIdrestaurateur() {
        return idrestaurateur;
    }

    public void setIdrestaurateur(Restaurateur idrestaurateur) {
        this.idrestaurateur = idrestaurateur;
    }


    @Override
    public String toString() {
        return "Resto{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    /*
    recharcher equals
    comparer deux restos qui sont le même ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resto that = (Resto) o;

        if (idrestaurateur != null ? !idrestaurateur.equals(that.idrestaurateur) : that.idrestaurateur != null) return false;

        return nom != null ? !nom.equals(that.nom) : that.nom == null;
    }

    /*
    retourner le hashcode d'un resto
     */
    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        return result;
    }
}
