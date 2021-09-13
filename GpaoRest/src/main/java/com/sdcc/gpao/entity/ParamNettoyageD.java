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
@Table(name = "ParamNettoyageD")
@NamedQueries({
    @NamedQuery(name = "ParamNettoyageD.findAll", query = "SELECT p FROM ParamNettoyageD p"),
    @NamedQuery(name = "ParamNettoyageD.findByIdparamnettoyaged", query = "SELECT p FROM ParamNettoyageD p WHERE p.idparamnettoyaged = :idparamnettoyaged"),
    @NamedQuery(name = "ParamNettoyageD.findByIndexvarvis1025A", query = "SELECT p FROM ParamNettoyageD p WHERE p.indexvarvis1025A = :indexvarvis1025A"),
    @NamedQuery(name = "ParamNettoyageD.findByIndexvarvis1025B", query = "SELECT p FROM ParamNettoyageD p WHERE p.indexvarvis1025B = :indexvarvis1025B"),
    @NamedQuery(name = "ParamNettoyageD.findByBandepeseuse", query = "SELECT p FROM ParamNettoyageD p WHERE p.bandepeseuse = :bandepeseuse"),
    @NamedQuery(name = "ParamNettoyageD.findByIndexvaralim1340", query = "SELECT p FROM ParamNettoyageD p WHERE p.indexvaralim1340 = :indexvaralim1340"),
    @NamedQuery(name = "ParamNettoyageD.findByIndexvaralim1341", query = "SELECT p FROM ParamNettoyageD p WHERE p.indexvaralim1341 = :indexvaralim1341"),
    @NamedQuery(name = "ParamNettoyageD.findByIndexvaralim1342", query = "SELECT p FROM ParamNettoyageD p WHERE p.indexvaralim1342 = :indexvaralim1342"),
    @NamedQuery(name = "ParamNettoyageD.findByValidated", query = "SELECT p FROM ParamNettoyageD p WHERE p.validated = :validated")})
public class ParamNettoyageD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_param_nettoyage_d")
    private Integer idparamnettoyaged;
    @Basic(optional = false)
    @Column(name = "Index_var_vis_1025A")
    private float indexvarvis1025A;
    @Basic(optional = false)
    @Column(name = "Index_var_vis_1025B")
    private float indexvarvis1025B;
    @Basic(optional = false)
    @Column(name = "Bande_peseuse")
    private float bandepeseuse;
    @Basic(optional = false)
    @Column(name = "Index_var_alim_1340")
    private float indexvaralim1340;
    @Basic(optional = false)
    @Column(name = "Index_var_alim_1341")
    private float indexvaralim1341;
    @Basic(optional = false)
    @Column(name = "Index_var_alim_1342")
    private float indexvaralim1342;
    @Column(name = "Validated")
    private Boolean validated;
    @JoinColumn(name = "Id_decoupage", referencedColumnName = "Id_decoupage")
    @ManyToOne(optional = false)
    private DecoupageHoraire iddecoupage;
    @JoinColumn(name = "Id_personnel", referencedColumnName = "Id_personnel")
    @ManyToOne
    private Personnel idpersonnel;
    @JoinColumn(name = "Id_planning", referencedColumnName = "Id_planning")
    @ManyToOne(optional = false)
    private Planning idplanning;

    public ParamNettoyageD() {
    }

    public ParamNettoyageD(Integer idparamnettoyaged) {
        this.idparamnettoyaged = idparamnettoyaged;
    }

    public ParamNettoyageD(Integer idparamnettoyaged, float indexvarvis1025A, float indexvarvis1025B, float bandepeseuse, float indexvaralim1340, float indexvaralim1341, float indexvaralim1342) {
        this.idparamnettoyaged = idparamnettoyaged;
        this.indexvarvis1025A = indexvarvis1025A;
        this.indexvarvis1025B = indexvarvis1025B;
        this.bandepeseuse = bandepeseuse;
        this.indexvaralim1340 = indexvaralim1340;
        this.indexvaralim1341 = indexvaralim1341;
        this.indexvaralim1342 = indexvaralim1342;
    }

    public Integer getIdparamnettoyaged() {
        return idparamnettoyaged;
    }

    public void setIdparamnettoyaged(Integer idparamnettoyaged) {
        this.idparamnettoyaged = idparamnettoyaged;
    }

    public float getIndexvarvis1025A() {
        return indexvarvis1025A;
    }

    public void setIndexvarvis1025A(float indexvarvis1025A) {
        this.indexvarvis1025A = indexvarvis1025A;
    }

    public float getIndexvarvis1025B() {
        return indexvarvis1025B;
    }

    public void setIndexvarvis1025B(float indexvarvis1025B) {
        this.indexvarvis1025B = indexvarvis1025B;
    }

    public float getBandepeseuse() {
        return bandepeseuse;
    }

    public void setBandepeseuse(float bandepeseuse) {
        this.bandepeseuse = bandepeseuse;
    }

    public float getIndexvaralim1340() {
        return indexvaralim1340;
    }

    public void setIndexvaralim1340(float indexvaralim1340) {
        this.indexvaralim1340 = indexvaralim1340;
    }

    public float getIndexvaralim1341() {
        return indexvaralim1341;
    }

    public void setIndexvaralim1341(float indexvaralim1341) {
        this.indexvaralim1341 = indexvaralim1341;
    }

    public float getIndexvaralim1342() {
        return indexvaralim1342;
    }

    public void setIndexvaralim1342(float indexvaralim1342) {
        this.indexvaralim1342 = indexvaralim1342;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public DecoupageHoraire getIddecoupage() {
        return iddecoupage;
    }

    public void setIddecoupage(DecoupageHoraire iddecoupage) {
        this.iddecoupage = iddecoupage;
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
        hash += (idparamnettoyaged != null ? idparamnettoyaged.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParamNettoyageD)) {
            return false;
        }
        ParamNettoyageD other = (ParamNettoyageD) object;
        if ((this.idparamnettoyaged == null && other.idparamnettoyaged != null) || (this.idparamnettoyaged != null && !this.idparamnettoyaged.equals(other.idparamnettoyaged))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.ParamNettoyageD[ idparamnettoyaged=" + idparamnettoyaged + " ]";
    }
    
}
