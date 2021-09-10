/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sodecoton
 */
@SuppressWarnings("serial")
@Embeddable
public class ParamPlanningPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Id_param_planning")
    private int idparamplanning;
    @Basic(optional = false)
    @Column(name = "Id_horaire")
    private int idhoraire;
    @Basic(optional = false)
    @Column(name = "Date_base")
    //@Temporal(TemporalType.DATE)
    private LocalDate datebase;

    public ParamPlanningPK() {
    }

    public ParamPlanningPK(int idparamplanning, int idhoraire, LocalDate datebase) {
        this.idparamplanning = idparamplanning;
        this.idhoraire = idhoraire;
        this.datebase = datebase;
    }

    public int getIdparamplanning() {
        return idparamplanning;
    }

    public void setIdparamplanning(int idparamplanning) {
        this.idparamplanning = idparamplanning;
    }

    public int getIdhoraire() {
        return idhoraire;
    }

    public void setIdhoraire(int idhoraire) {
        this.idhoraire = idhoraire;
    }

    public LocalDate getDatebase() {
        return datebase;
    }

    public void setDatebase(LocalDate datebase) {
        this.datebase = datebase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idparamplanning;
        hash += (int) idhoraire;
        hash += (datebase != null ? datebase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParamPlanningPK)) {
            return false;
        }
        ParamPlanningPK other = (ParamPlanningPK) object;
        if (this.idparamplanning != other.idparamplanning) {
            return false;
        }
        if (this.idhoraire != other.idhoraire) {
            return false;
        }
        if ((this.datebase == null && other.datebase != null) || (this.datebase != null && !this.datebase.equals(other.datebase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.ParamPlanningPK[ idparamplanning=" + idparamplanning + ", idhoraire=" + idhoraire + ", datebase=" + datebase + " ]";
    }
    
}
