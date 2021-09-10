/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Sodecoton
 */
@Entity
@Table(name = "Planning")
@NamedQueries({
    @NamedQuery(name = "Planning.findAll", query = "SELECT p FROM Planning p"),
    @NamedQuery(name = "Planning.findByIdplanning", query = "SELECT p FROM Planning p WHERE p.idplanning = :idplanning"),
    @NamedQuery(name = "Planning.findByDateplanning", query = "SELECT p FROM Planning p WHERE p.dateplanning = :dateplanning"),
    @NamedQuery(name = "Planning.findByStatut", query = "SELECT p FROM Planning p WHERE p.statut = :statut")})
public class Planning implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_planning")
    private Integer idplanning;
    @Column(name = "Date_planning")
    //@Temporal(TemporalType.DATE)
    private LocalDate dateplanning;
    @Column(name = "Statut")
    private String statut;
    //@JsonIgnoreProperties("idplanning")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplanning", fetch = FetchType.LAZY)
    private Collection<ActiviteNettoyageD> activiteNettoyageDCollection;
   // @JsonIgnoreProperties("idplanning")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplanning", fetch = FetchType.LAZY)
    private Collection<ParamNettoyageD> paramNettoyageDCollection;
   // @JsonIgnoreProperties("idplanning")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplanning", fetch = FetchType.LAZY)
    private Collection<AnalyseNettPressPell> analyseNettPressPellCollection;
   // @JsonIgnoreProperties("idplanning")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplanning", fetch = FetchType.LAZY)
    private Collection<NettoyageD> nettoyageDCollection;
    @JoinColumn(name = "Id_horaire", referencedColumnName = "Id_horaire")
    @ManyToOne(optional = false)
    private Horaire idhoraire;
    @JoinColumn(name = "Id_quart", referencedColumnName = "Id_quart")
    @ManyToOne(optional = false)
    private Quart idquart;

    public Planning() {
    }

    public Planning(Integer idplanning) {
        this.idplanning = idplanning;
    }

    public Integer getIdplanning() {
        return idplanning;
    }

    public void setIdplanning(Integer idplanning) {
        this.idplanning = idplanning;
    }

    public LocalDate getDateplanning() {
        return dateplanning;
    }

    public void setDateplanning(LocalDate dateplanning) {
        this.dateplanning = dateplanning;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @JsonIgnore
    public Collection<ActiviteNettoyageD> getActiviteNettoyageDCollection() {
        return activiteNettoyageDCollection;
    }

    public void setActiviteNettoyageDCollection(Collection<ActiviteNettoyageD> activiteNettoyageDCollection) {
        this.activiteNettoyageDCollection = activiteNettoyageDCollection;
    }

    @JsonIgnore
    public Collection<ParamNettoyageD> getParamNettoyageDCollection() {
        return paramNettoyageDCollection;
    }

    public void setParamNettoyageDCollection(Collection<ParamNettoyageD> paramNettoyageDCollection) {
        this.paramNettoyageDCollection = paramNettoyageDCollection;
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

    public Horaire getIdhoraire() {
        return idhoraire;
    }

    public void setIdhoraire(Horaire idhoraire) {
        this.idhoraire = idhoraire;
    }

    public Quart getIdquart() {
        return idquart;
    }

    public void setIdquart(Quart idquart) {
        this.idquart = idquart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplanning != null ? idplanning.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.idplanning == null && other.idplanning != null) || (this.idplanning != null && !this.idplanning.equals(other.idplanning))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.Planning[ idplanning=" + idplanning + " ]";
    }
    
}
