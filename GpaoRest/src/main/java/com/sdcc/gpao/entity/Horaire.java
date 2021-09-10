/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import java.time.LocalTime;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Sodecoton
 */
@Entity
@Table(name = "Horaire")
@NamedQueries({
    @NamedQuery(name = "Horaire.findAll", query = "SELECT h FROM Horaire h"),
    @NamedQuery(name = "Horaire.findByIdhoraire", query = "SELECT h FROM Horaire h WHERE h.idhoraire = :idhoraire"),
    @NamedQuery(name = "Horaire.findByHeuredebut", query = "SELECT h FROM Horaire h WHERE h.heuredebut = :heuredebut"),
    @NamedQuery(name = "Horaire.findByHeurefin", query = "SELECT h FROM Horaire h WHERE h.heurefin = :heurefin"),
    @NamedQuery(name = "Horaire.findByOrdre", query = "SELECT h FROM Horaire h WHERE h.ordre = :ordre")})
public class Horaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_horaire")
    private Integer idhoraire;
    @Basic(optional = false)
    @Column(name = "Heure_debut")
    //@Temporal(TemporalType.TIME)
    private LocalTime heuredebut;
    @Basic(optional = false)
    @Column(name = "Heure_fin")
    //@Temporal(TemporalType.TIME)
    private LocalTime heurefin;
    @Column(name = "Ordre")
    private Integer ordre;
    //@JsonIgnoreProperties("idhoraire")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhoraire", fetch = FetchType.LAZY)
    private Collection<ParamNettoyageD> paramNettoyageDCollection;
    //@JsonIgnoreProperties("idhoraire")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhoraire", fetch = FetchType.LAZY)
    private Collection<Planning> planningCollection;
    //@JsonIgnoreProperties("horaire")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horaire", fetch = FetchType.LAZY)
    private Collection<ParamPlanning> paramPlanningCollection;

    public Horaire() {
    }

    public Horaire(Integer idhoraire) {
        this.idhoraire = idhoraire;
    }

    public Horaire(Integer idhoraire, LocalTime heuredebut, LocalTime heurefin) {
        this.idhoraire = idhoraire;
        this.heuredebut = heuredebut;
        this.heurefin = heurefin;
    }

    public Integer getIdhoraire() {
        return idhoraire;
    }

    public void setIdhoraire(Integer idhoraire) {
        this.idhoraire = idhoraire;
    }

    public LocalTime getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(LocalTime heuredebut) {
        this.heuredebut = heuredebut;
    }

    public LocalTime getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(LocalTime heurefin) {
        this.heurefin = heurefin;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    @JsonIgnore
    public Collection<ParamNettoyageD> getParamNettoyageDCollection() {
        return paramNettoyageDCollection;
    }

    public void setParamNettoyageDCollection(Collection<ParamNettoyageD> paramNettoyageDCollection) {
        this.paramNettoyageDCollection = paramNettoyageDCollection;
    }

    @JsonIgnore
    public Collection<Planning> getPlanningCollection() {
        return planningCollection;
    }

    public void setPlanningCollection(Collection<Planning> planningCollection) {
        this.planningCollection = planningCollection;
    }

    @JsonIgnore
    public Collection<ParamPlanning> getParamPlanningCollection() {
        return paramPlanningCollection;
    }

    public void setParamPlanningCollection(Collection<ParamPlanning> paramPlanningCollection) {
        this.paramPlanningCollection = paramPlanningCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhoraire != null ? idhoraire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horaire)) {
            return false;
        }
        Horaire other = (Horaire) object;
        if ((this.idhoraire == null && other.idhoraire != null) || (this.idhoraire != null && !this.idhoraire.equals(other.idhoraire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.Horaire[ idhoraire=" + idhoraire + " ]";
    }
    
}
