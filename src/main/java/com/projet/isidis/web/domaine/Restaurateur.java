package com.projet.isidis.web.domaine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema="projet_isidis",name="restaurateur")
public class Restaurateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotNull
    @Size(min=1, max=45)
    @Column
    private String nom;
    @NotNull
    @Size(min=1, max=45)
    @Column
    private String prenom;
    @NotNull
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.adresse}")
    @Size(min=1, max=50)
    @Column
    private String email;
    @NotNull
    @Size(min=1, max=20)
    @Column
    private String pwd;
    @NotNull
    @Column
    private Date datenaissance;
    @NotNull
    @Pattern(regexp="M|F")
    @Column
    private String sex;
    @NotNull
    @Size(min=1, max=20)
    @Column
    private String portable;
    @NotNull
    @Size(min=1, max=20)
    @Column
    private String telephone;
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
    @NotNull
    @Size(min=1, max=15)
    @Column
    private String pays;
    @NotNull
    @Size(min=1, max=50)
    @Column
    private String id_identity;

    @OneToMany(mappedBy="idrestaurateur",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Resto> restos = new HashSet<Resto>();
    public void addResto(Resto resto){ this.restos.add(resto); }
    public Set<Resto> getRestos(){ return this.restos; }
    public void setRestos(Set<Resto> restos){ this.restos=restos; }

    public Restaurateur() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getDateNaissance() {
        return datenaissance;
    }

    public void setDateNaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getId_identity() {
        return id_identity;
    }

    public void setId_identity(String id_identity) {
        this.id_identity = id_identity;
    }
}
