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
@Table(name = "Quart")
@NamedQueries({
    @NamedQuery(name = "Quart.findAll", query = "SELECT q FROM Quart q"),
    @NamedQuery(name = "Quart.findByIdquart", query = "SELECT q FROM Quart q WHERE q.idquart = :idquart"),
    @NamedQuery(name = "Quart.findByNomquart", query = "SELECT q FROM Quart q WHERE q.nomquart = :nomquart")})
public class Quart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_quart")
    private Integer idquart;
    @Column(name = "Nom_quart")
    private String nomquart;
    @OneToMany(mappedBy = "idquart", fetch = FetchType.LAZY)
    private Collection<Personnel> personnelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquart", fetch = FetchType.LAZY)
    private Collection<Planning> planningCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquart", fetch = FetchType.LAZY)
    private Collection<ParamPlanning> paramPlanningCollection;

    public Quart() {
    }

    public Quart(Integer idquart) {
        this.idquart = idquart;
    }

    public Integer getIdquart() {
        return idquart;
    }

    public void setIdquart(Integer idquart) {
        this.idquart = idquart;
    }

    public String getNomquart() {
        return nomquart;
    }

    public void setNomquart(String nomquart) {
        this.nomquart = nomquart;
    }

    @JsonIgnore
    public Collection<Personnel> getPersonnelCollection() {
        return personnelCollection;
    }

    public void setPersonnelCollection(Collection<Personnel> personnelCollection) {
        this.personnelCollection = personnelCollection;
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
        hash += (idquart != null ? idquart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quart)) {
            return false;
        }
        Quart other = (Quart) object;
        if ((this.idquart == null && other.idquart != null) || (this.idquart != null && !this.idquart.equals(other.idquart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.Quart[ idquart=" + idquart + " ]";
    }
    
}
