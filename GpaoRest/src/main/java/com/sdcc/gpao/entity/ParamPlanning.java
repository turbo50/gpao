/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sodecoton
 */
@Entity
@Table(name = "ParamPlanning")
@NamedQueries({
    @NamedQuery(name = "ParamPlanning.findAll", query = "SELECT p FROM ParamPlanning p"),
    @NamedQuery(name = "ParamPlanning.findByIdparamplanning", query = "SELECT p FROM ParamPlanning p WHERE p.paramPlanningPK.idparamplanning = :idparamplanning"),
    @NamedQuery(name = "ParamPlanning.findByIdhoraire", query = "SELECT p FROM ParamPlanning p WHERE p.paramPlanningPK.idhoraire = :idhoraire"),
    @NamedQuery(name = "ParamPlanning.findByDatebase", query = "SELECT p FROM ParamPlanning p WHERE p.paramPlanningPK.datebase = :datebase")})
public class ParamPlanning implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParamPlanningPK paramPlanningPK;
    @JoinColumn(name = "Id_horaire", referencedColumnName = "Id_horaire", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Horaire horaire;
    @JoinColumn(name = "Id_quart", referencedColumnName = "Id_quart")
    @ManyToOne(optional = false)
    private Quart idquart;

    public ParamPlanning() {
    }

    public ParamPlanning(ParamPlanningPK paramPlanningPK) {
        this.paramPlanningPK = paramPlanningPK;
    }

    public ParamPlanning(int idparamplanning, int idhoraire, LocalDate datebase) {
        this.paramPlanningPK = new ParamPlanningPK(idparamplanning, idhoraire, datebase);
    }

    public ParamPlanningPK getParamPlanningPK() {
        return paramPlanningPK;
    }

    public void setParamPlanningPK(ParamPlanningPK paramPlanningPK) {
        this.paramPlanningPK = paramPlanningPK;
    }

    public Horaire getHoraire() {
        return horaire;
    }

    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
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
        hash += (paramPlanningPK != null ? paramPlanningPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParamPlanning)) {
            return false;
        }
        ParamPlanning other = (ParamPlanning) object;
        if ((this.paramPlanningPK == null && other.paramPlanningPK != null) || (this.paramPlanningPK != null && !this.paramPlanningPK.equals(other.paramPlanningPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.ParamPlanning[ paramPlanningPK=" + paramPlanningPK + " ]";
    }
    
}
