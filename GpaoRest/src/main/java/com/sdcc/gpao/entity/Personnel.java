/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Personnel")
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
    @NamedQuery(name = "Personnel.findByIdpersonnel", query = "SELECT p FROM Personnel p WHERE p.idpersonnel = :idpersonnel"),
    @NamedQuery(name = "Personnel.findByNom", query = "SELECT p FROM Personnel p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personnel.findByMatricule", query = "SELECT p FROM Personnel p WHERE p.matricule = :matricule"),
    @NamedQuery(name = "Personnel.findByFonction", query = "SELECT p FROM Personnel p WHERE p.fonction = :fonction")})
public class Personnel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_personnel")
    private Integer idpersonnel;
    @Basic(optional = false)
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Matricule")
    private String matricule;
    @Column(name = "Fonction")
    private String fonction;
    @OneToMany(mappedBy = "idpersonnel", fetch = FetchType.LAZY)
    private Collection<ActiviteNettoyageD> activiteNettoyageDCollection;
    @OneToMany(mappedBy = "idpersonnel", fetch = FetchType.LAZY)
    private Collection<Reception> receptionCollection;
    @OneToMany(mappedBy = "idpersonnel", fetch = FetchType.LAZY)
    private Collection<ParamNettoyageD> paramNettoyageDCollection;
    @JoinColumn(name = "Id_quart", referencedColumnName = "Id_quart")
    @ManyToOne(fetch = FetchType.LAZY)
    private Quart idquart;
    @OneToMany(mappedBy = "idpersonnel", fetch = FetchType.LAZY)
    private Collection<AnalyseNettPressPell> analyseNettPressPellCollection;
    @OneToMany(mappedBy = "idpersonnel", fetch = FetchType.LAZY)
    private Collection<NettoyageD> nettoyageDCollection;

    public Personnel() {
    }

    public Personnel(Integer idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public Personnel(Integer idpersonnel, String nom) {
        this.idpersonnel = idpersonnel;
        this.nom = nom;
    }

    public Integer getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(Integer idpersonnel) {
        this.idpersonnel = idpersonnel;
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

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @JsonIgnore
    public Collection<ActiviteNettoyageD> getActiviteNettoyageDCollection() {
        return activiteNettoyageDCollection;
    }

    public void setActiviteNettoyageDCollection(Collection<ActiviteNettoyageD> activiteNettoyageDCollection) {
        this.activiteNettoyageDCollection = activiteNettoyageDCollection;
    }

    @JsonIgnore
    public Collection<Reception> getReceptionCollection() {
        return receptionCollection;
    }

    public void setReceptionCollection(Collection<Reception> receptionCollection) {
        this.receptionCollection = receptionCollection;
    }

    @JsonIgnore
    public Collection<ParamNettoyageD> getParamNettoyageDCollection() {
        return paramNettoyageDCollection;
    }

    public void setParamNettoyageDCollection(Collection<ParamNettoyageD> paramNettoyageDCollection) {
        this.paramNettoyageDCollection = paramNettoyageDCollection;
    }

    public Quart getIdquart() {
        return idquart;
    }

    public void setIdquart(Quart idquart) {
        this.idquart = idquart;
    }

    @JsonIgnore
    public Collection<AnalyseNettPressPell> getAnalyseNettPressPellCollection() {
        return analyseNettPressPellCollection;
    }

    public void setAnalyseNettPressPellCollection(Collection<AnalyseNettPressPell> analyseNettPressPellCollection) {
        this.analyseNettPressPellCollection = analyseNettPressPellCollection;
    }

    @JsonIgnore
    public Collection<NettoyageD> getNettoyageDCollection() {
        return nettoyageDCollection;
    }

    public void setNettoyageDCollection(Collection<NettoyageD> nettoyageDCollection) {
        this.nettoyageDCollection = nettoyageDCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonnel != null ? idpersonnel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.idpersonnel == null && other.idpersonnel != null) || (this.idpersonnel != null && !this.idpersonnel.equals(other.idpersonnel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.Personnel[ idpersonnel=" + idpersonnel + " ]";
    }
    
}
