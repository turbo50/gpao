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
@Table(name = "ActiviteNettoyageD")
@NamedQueries({
    @NamedQuery(name = "ActiviteNettoyageD.findAll", query = "SELECT a FROM ActiviteNettoyageD a"),
    @NamedQuery(name = "ActiviteNettoyageD.findByIdactivite", query = "SELECT a FROM ActiviteNettoyageD a WHERE a.idactivite = :idactivite"),
    @NamedQuery(name = "ActiviteNettoyageD.findBySoufflagegrille", query = "SELECT a FROM ActiviteNettoyageD a WHERE a.soufflagegrille = :soufflagegrille"),
    @NamedQuery(name = "ActiviteNettoyageD.findByNettoyageplaque", query = "SELECT a FROM ActiviteNettoyageD a WHERE a.nettoyageplaque = :nettoyageplaque"),
    @NamedQuery(name = "ActiviteNettoyageD.findByNettoyageaimant", query = "SELECT a FROM ActiviteNettoyageD a WHERE a.nettoyageaimant = :nettoyageaimant"),
    @NamedQuery(name = "ActiviteNettoyageD.findByAutre", query = "SELECT a FROM ActiviteNettoyageD a WHERE a.autre = :autre"),
    @NamedQuery(name = "ActiviteNettoyageD.findByValidated", query = "SELECT a FROM ActiviteNettoyageD a WHERE a.validated = :validated")})
public class ActiviteNettoyageD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_activite")
    private Integer idactivite;
    @Column(name = "Soufflage_grille")
    private String soufflagegrille;
    @Column(name = "Nettoyage_plaque")
    private String nettoyageplaque;
    @Column(name = "Nettoyage_aimant")
    private String nettoyageaimant;
    @Column(name = "Autre")
    private String autre;
    @Column(name = "Validated")
    private Boolean validated;
    @JoinColumn(name = "Id_personnel", referencedColumnName = "Id_personnel")
    @ManyToOne
    private Personnel idpersonnel;
    @JoinColumn(name = "Id_planning", referencedColumnName = "Id_planning")
    @ManyToOne(optional = false)
    private Planning idplanning;

    public ActiviteNettoyageD() {
    }

    public ActiviteNettoyageD(Integer idactivite) {
        this.idactivite = idactivite;
    }

    public Integer getIdactivite() {
        return idactivite;
    }

    public void setIdactivite(Integer idactivite) {
        this.idactivite = idactivite;
    }

    public String getSoufflagegrille() {
        return soufflagegrille;
    }

    public void setSoufflagegrille(String soufflagegrille) {
        this.soufflagegrille = soufflagegrille;
    }

    public String getNettoyageplaque() {
        return nettoyageplaque;
    }

    public void setNettoyageplaque(String nettoyageplaque) {
        this.nettoyageplaque = nettoyageplaque;
    }

    public String getNettoyageaimant() {
        return nettoyageaimant;
    }

    public void setNettoyageaimant(String nettoyageaimant) {
        this.nettoyageaimant = nettoyageaimant;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
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
        hash += (idactivite != null ? idactivite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActiviteNettoyageD)) {
            return false;
        }
        ActiviteNettoyageD other = (ActiviteNettoyageD) object;
        if ((this.idactivite == null && other.idactivite != null) || (this.idactivite != null && !this.idactivite.equals(other.idactivite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.ActiviteNettoyageD[ idactivite=" + idactivite + " ]";
    }
    
}
