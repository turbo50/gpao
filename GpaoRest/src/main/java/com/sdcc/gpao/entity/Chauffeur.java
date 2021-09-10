/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Sodecoton
 */
@Entity
@Table(name = "Chauffeur")
@NamedQueries({
    @NamedQuery(name = "Chauffeur.findAll", query = "SELECT c FROM Chauffeur c"),
    @NamedQuery(name = "Chauffeur.findByIdchauffeur", query = "SELECT c FROM Chauffeur c WHERE c.idchauffeur = :idchauffeur"),
    @NamedQuery(name = "Chauffeur.findByNom", query = "SELECT c FROM Chauffeur c WHERE c.nom = :nom"),
    @NamedQuery(name = "Chauffeur.findByMatricule", query = "SELECT c FROM Chauffeur c WHERE c.matricule = :matricule")})
public class Chauffeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_chauffeur")
    private Integer idchauffeur;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Matricule")
    private String matricule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idchauffeur", fetch = FetchType.LAZY)
    private Collection<Reception> receptionCollection;

    public Chauffeur() {
    }

    public Chauffeur(Integer idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    public Integer getIdchauffeur() {
        return idchauffeur;
    }

    public void setIdchauffeur(Integer idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @JsonIgnore
    public Collection<Reception> getReceptionCollection() {
        return receptionCollection;
    }

    public void setReceptionCollection(Collection<Reception> receptionCollection) {
        this.receptionCollection = receptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchauffeur != null ? idchauffeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chauffeur)) {
            return false;
        }
        Chauffeur other = (Chauffeur) object;
        if ((this.idchauffeur == null && other.idchauffeur != null) || (this.idchauffeur != null && !this.idchauffeur.equals(other.idchauffeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.Chauffeur[ idchauffeur=" + idchauffeur + " ]";
    }
    
}
