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
    @NamedQuery(name = "NettoyageD.findByIndexbande", query = "SELECT n FROM NettoyageD n WHERE n.indexbande = :indexbande"),
    @NamedQuery(name = "NettoyageD.findByValidated", query = "SELECT n FROM NettoyageD n WHERE n.validated = :validated")})
public class NettoyageD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_nettoyage_d")
    private Integer idnettoyaged;
    @Basic(optional = false)
    @Column(name = "Index_bande")
    private int indexbande;
    @Basic(optional = false)
    @Column(name = "Validated")
    private boolean validated;
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

    public NettoyageD(Integer idnettoyaged, int indexbande, boolean validated) {
        this.idnettoyaged = idnettoyaged;
        this.indexbande = indexbande;
        this.validated = validated;
    }

    public Integer getIdnettoyaged() {
        return idnettoyaged;
    }

    public void setIdnettoyaged(Integer idnettoyaged) {
        this.idnettoyaged = idnettoyaged;
    }

    public int getIndexbande() {
        return indexbande;
    }

    public void setIndexbande(int indexbande) {
        this.indexbande = indexbande;
    }

    public boolean getValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
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
