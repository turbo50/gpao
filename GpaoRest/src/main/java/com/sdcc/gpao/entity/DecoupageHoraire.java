/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import java.time.LocalTime;
//import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

/**
 *
 * @author Sodecoton
 */
@Entity
@Table(name = "DecoupageHoraire")
@NamedQueries({
    @NamedQuery(name = "DecoupageHoraire.findAll", query = "SELECT d FROM DecoupageHoraire d"),
    @NamedQuery(name = "DecoupageHoraire.findByIddecoupage", query = "SELECT d FROM DecoupageHoraire d WHERE d.iddecoupage = :iddecoupage"),
    @NamedQuery(name = "DecoupageHoraire.findByHeure", query = "SELECT d FROM DecoupageHoraire d WHERE d.heure = :heure")})
public class DecoupageHoraire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_decoupage")
    private Integer iddecoupage;
    @Column(name = "Heure")
    //@Temporal(TemporalType.TIME)
    private LocalTime heure;

    public DecoupageHoraire() {
    }

    public DecoupageHoraire(Integer iddecoupage) {
        this.iddecoupage = iddecoupage;
    }

    public Integer getIddecoupage() {
        return iddecoupage;
    }

    public void setIddecoupage(Integer iddecoupage) {
        this.iddecoupage = iddecoupage;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddecoupage != null ? iddecoupage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DecoupageHoraire)) {
            return false;
        }
        DecoupageHoraire other = (DecoupageHoraire) object;
        if ((this.iddecoupage == null && other.iddecoupage != null) || (this.iddecoupage != null && !this.iddecoupage.equals(other.iddecoupage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.DecoupageHoraire[ iddecoupage=" + iddecoupage + " ]";
    }
    
}
