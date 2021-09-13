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
@Table(name = "AnalyseNettPressPell")
@NamedQueries({
    @NamedQuery(name = "AnalyseNettPressPell.findAll", query = "SELECT a FROM AnalyseNettPressPell a"),
    @NamedQuery(name = "AnalyseNettPressPell.findByIdanalyse", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.idanalyse = :idanalyse"),
    @NamedQuery(name = "AnalyseNettPressPell.findByIdpersonnel", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.idpersonnel = :idpersonnel"),
    @NamedQuery(name = "AnalyseNettPressPell.findByGrmg", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.grmg = :grmg"),
    @NamedQuery(name = "AnalyseNettPressPell.findByGrh2o", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.grh2o = :grh2o"),
    @NamedQuery(name = "AnalyseNettPressPell.findByGrca", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.grca = :grca"),
    @NamedQuery(name = "AnalyseNettPressPell.findByAmmg", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.ammg = :ammg"),
    @NamedQuery(name = "AnalyseNettPressPell.findByAmh2o", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.amh2o = :amh2o"),
    @NamedQuery(name = "AnalyseNettPressPell.findByCoqech1340", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.coqech1340 = :coqech1340"),
    @NamedQuery(name = "AnalyseNettPressPell.findByCoqech1341", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.coqech1341 = :coqech1341"),
    @NamedQuery(name = "AnalyseNettPressPell.findByCoqech1342", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.coqech1342 = :coqech1342"),
    @NamedQuery(name = "AnalyseNettPressPell.findByCoqmg", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.coqmg = :coqmg"),
    @NamedQuery(name = "AnalyseNettPressPell.findByCoqh2o", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.coqh2o = :coqh2o"),
    @NamedQuery(name = "AnalyseNettPressPell.findByAmech2o", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.amech2o = :amech2o"),
    @NamedQuery(name = "AnalyseNettPressPell.findByAmeccoq", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.ameccoq = :ameccoq"),
    @NamedQuery(name = "AnalyseNettPressPell.findByAmsch2o", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.amsch2o = :amsch2o"),
    @NamedQuery(name = "AnalyseNettPressPell.findByCollecaillmg", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.collecaillmg = :collecaillmg"),
    @NamedQuery(name = "AnalyseNettPressPell.findByCollecaillh2o", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.collecaillh2o = :collecaillh2o"),
    @NamedQuery(name = "AnalyseNettPressPell.findByDefbroy", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.defbroy = :defbroy"),
    @NamedQuery(name = "AnalyseNettPressPell.findByPellet", query = "SELECT a FROM AnalyseNettPressPell a WHERE a.pellet = :pellet")})
public class AnalyseNettPressPell implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_analyse")
    private Integer idanalyse;
    @Column(name = "Id_personnel")
    private Integer idpersonnel;
    @Basic(optional = false)
    @Column(name = "Gr_mg")
    private float grmg;
    @Basic(optional = false)
    @Column(name = "Gr_h2o")
    private float grh2o;
    @Basic(optional = false)
    @Column(name = "Gr_c_a")
    private float grca;
    @Basic(optional = false)
    @Column(name = "Am_mg")
    private float ammg;
    @Basic(optional = false)
    @Column(name = "Am_h2o")
    private float amh2o;
    @Basic(optional = false)
    @Column(name = "Coq_ech_1340")
    private float coqech1340;
    @Basic(optional = false)
    @Column(name = "Coq_ech_1341")
    private float coqech1341;
    @Basic(optional = false)
    @Column(name = "Coq_ech_1342")
    private float coqech1342;
    @Basic(optional = false)
    @Column(name = "Coq_mg")
    private float coqmg;
    @Basic(optional = false)
    @Column(name = "Coq_h2o")
    private float coqh2o;
    @Basic(optional = false)
    @Column(name = "Am_ec_h2o")
    private float amech2o;
    @Basic(optional = false)
    @Column(name = "Am_ec_coq")
    private float ameccoq;
    @Basic(optional = false)
    @Column(name = "Am_sc_h2o")
    private float amsch2o;
    @Basic(optional = false)
    @Column(name = "Coll_ecaill_mg")
    private float collecaillmg;
    @Basic(optional = false)
    @Column(name = "Coll_ecaill_h2o")
    private float collecaillh2o;
    @Basic(optional = false)
    @Column(name = "Def_broy")
    private float defbroy;
    @Basic(optional = false)
    @Column(name = "Pellet")
    private float pellet;
    @JoinColumn(name = "Id_planning", referencedColumnName = "Id_planning")
    @ManyToOne(optional = false)
    private Planning idplanning;

    public AnalyseNettPressPell() {
    }

    public AnalyseNettPressPell(Integer idanalyse) {
        this.idanalyse = idanalyse;
    }

    public AnalyseNettPressPell(Integer idanalyse, float grmg, float grh2o, float grca, float ammg, float amh2o, float coqech1340, float coqech1341, float coqech1342, float coqmg, float coqh2o, float amech2o, float ameccoq, float amsch2o, float collecaillmg, float collecaillh2o, float defbroy, float pellet) {
        this.idanalyse = idanalyse;
        this.grmg = grmg;
        this.grh2o = grh2o;
        this.grca = grca;
        this.ammg = ammg;
        this.amh2o = amh2o;
        this.coqech1340 = coqech1340;
        this.coqech1341 = coqech1341;
        this.coqech1342 = coqech1342;
        this.coqmg = coqmg;
        this.coqh2o = coqh2o;
        this.amech2o = amech2o;
        this.ameccoq = ameccoq;
        this.amsch2o = amsch2o;
        this.collecaillmg = collecaillmg;
        this.collecaillh2o = collecaillh2o;
        this.defbroy = defbroy;
        this.pellet = pellet;
    }

    public Integer getIdanalyse() {
        return idanalyse;
    }

    public void setIdanalyse(Integer idanalyse) {
        this.idanalyse = idanalyse;
    }

    public Integer getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(Integer idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public float getGrmg() {
        return grmg;
    }

    public void setGrmg(float grmg) {
        this.grmg = grmg;
    }

    public float getGrh2o() {
        return grh2o;
    }

    public void setGrh2o(float grh2o) {
        this.grh2o = grh2o;
    }

    public float getGrca() {
        return grca;
    }

    public void setGrca(float grca) {
        this.grca = grca;
    }

    public float getAmmg() {
        return ammg;
    }

    public void setAmmg(float ammg) {
        this.ammg = ammg;
    }

    public float getAmh2o() {
        return amh2o;
    }

    public void setAmh2o(float amh2o) {
        this.amh2o = amh2o;
    }

    public float getCoqech1340() {
        return coqech1340;
    }

    public void setCoqech1340(float coqech1340) {
        this.coqech1340 = coqech1340;
    }

    public float getCoqech1341() {
        return coqech1341;
    }

    public void setCoqech1341(float coqech1341) {
        this.coqech1341 = coqech1341;
    }

    public float getCoqech1342() {
        return coqech1342;
    }

    public void setCoqech1342(float coqech1342) {
        this.coqech1342 = coqech1342;
    }

    public float getCoqmg() {
        return coqmg;
    }

    public void setCoqmg(float coqmg) {
        this.coqmg = coqmg;
    }

    public float getCoqh2o() {
        return coqh2o;
    }

    public void setCoqh2o(float coqh2o) {
        this.coqh2o = coqh2o;
    }

    public float getAmech2o() {
        return amech2o;
    }

    public void setAmech2o(float amech2o) {
        this.amech2o = amech2o;
    }

    public float getAmeccoq() {
        return ameccoq;
    }

    public void setAmeccoq(float ameccoq) {
        this.ameccoq = ameccoq;
    }

    public float getAmsch2o() {
        return amsch2o;
    }

    public void setAmsch2o(float amsch2o) {
        this.amsch2o = amsch2o;
    }

    public float getCollecaillmg() {
        return collecaillmg;
    }

    public void setCollecaillmg(float collecaillmg) {
        this.collecaillmg = collecaillmg;
    }

    public float getCollecaillh2o() {
        return collecaillh2o;
    }

    public void setCollecaillh2o(float collecaillh2o) {
        this.collecaillh2o = collecaillh2o;
    }

    public float getDefbroy() {
        return defbroy;
    }

    public void setDefbroy(float defbroy) {
        this.defbroy = defbroy;
    }

    public float getPellet() {
        return pellet;
    }

    public void setPellet(float pellet) {
        this.pellet = pellet;
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
        hash += (idanalyse != null ? idanalyse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnalyseNettPressPell)) {
            return false;
        }
        AnalyseNettPressPell other = (AnalyseNettPressPell) object;
        if ((this.idanalyse == null && other.idanalyse != null) || (this.idanalyse != null && !this.idanalyse.equals(other.idanalyse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.AnalyseNettPressPell[ idanalyse=" + idanalyse + " ]";
    }
    
}
