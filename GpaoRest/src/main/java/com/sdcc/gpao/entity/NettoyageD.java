/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "NettoyageD")
@NamedQueries({
    @NamedQuery(name = "NettoyageD.findAll", query = "SELECT n FROM NettoyageD n"),
    @NamedQuery(name = "NettoyageD.findByIdnettoyaged", query = "SELECT n FROM NettoyageD n WHERE n.idnettoyaged = :idnettoyaged"),
    @NamedQuery(name = "NettoyageD.findByIndexbandeinit", query = "SELECT n FROM NettoyageD n WHERE n.indexbandeinit = :indexbandeinit"),
    @NamedQuery(name = "NettoyageD.findByIndexbandefinal", query = "SELECT n FROM NettoyageD n WHERE n.indexbandefinal = :indexbandefinal"),
    @NamedQuery(name = "NettoyageD.findByValidated", query = "SELECT n FROM NettoyageD n WHERE n.validated = :validated")})
public class NettoyageD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_nettoyage_d")
    private Integer idnettoyaged;
    @Basic(optional = false)
    @Column(name = "Index_bande_init")
    private long indexbandeinit;
    @Basic(optional = false)
    @Column(name = "Index_bande_final")
    private long indexbandefinal;
    @Column(name = "Validated")
    private Boolean validated;
    @JoinColumn(name = "Id_personnel", referencedColumnName = "Id_personnel")
    @ManyToOne
    private Personnel idpersonnel;
    @JoinColumn(name = "Id_planning", referencedColumnName = "Id_planning")
    @ManyToOne(optional = false)
    private Planning idplanning;

    public NettoyageD() {
    }

    public NettoyageD(Integer idnettoyaged) {
        this.idnettoyaged = idnettoyaged;
    }

    public NettoyageD(Integer idnettoyaged, long indexbandeinit, long indexbandefinal) {
        this.idnettoyaged = idnettoyaged;
        this.indexbandeinit = indexbandeinit;
        this.indexbandefinal = indexbandefinal;
    }

    public Integer getIdnettoyaged() {
        return idnettoyaged;
    }

    public void setIdnettoyaged(Integer idnettoyaged) {
        this.idnettoyaged = idnettoyaged;
    }

    public long getIndexbandeinit() {
        return indexbandeinit;
    }

    public void setIndexbandeinit(long indexbandeinit) {
        this.indexbandeinit = indexbandeinit;
    }

    public long getIndexbandefinal() {
        return indexbandefinal;
    }

    public void setIndexbandefinal(long indexbandefinal) {
        this.indexbandefinal = indexbandefinal;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Personnel getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(Personnel idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public Planning getIdplanning() {
        return idplanning;
    }

    public void setIdplanning(Planning idplanning) {
        this.idplanning = idplanning;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnettoyaged != null ? idnettoyaged.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NettoyageD)) {
            return false;
        }
        NettoyageD other = (NettoyageD) object;
        if ((this.idnettoyaged == null && other.idnettoyaged != null) || (this.idnettoyaged != null && !this.idnettoyaged.equals(other.idnettoyaged))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.NettoyageD[ idnettoyaged=" + idnettoyaged + " ]";
    }
    
}
