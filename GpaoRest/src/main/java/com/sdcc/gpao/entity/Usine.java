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
@Table(name = "Usine")
@NamedQueries({
    @NamedQuery(name = "Usine.findAll", query = "SELECT u FROM Usine u"),
    @NamedQuery(name = "Usine.findByIdusine", query = "SELECT u FROM Usine u WHERE u.idusine = :idusine"),
    @NamedQuery(name = "Usine.findByNomusine", query = "SELECT u FROM Usine u WHERE u.nomusine = :nomusine"),
    @NamedQuery(name = "Usine.findByCodeusine", query = "SELECT u FROM Usine u WHERE u.codeusine = :codeusine")})
public class Usine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_usine")
    private Integer idusine;
    @Column(name = "Nom_usine")
    private String nomusine;
    @Column(name = "Code_usine")
    private String codeusine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusinerecep", fetch = FetchType.LAZY)
    private Collection<Reception> receptions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusineexp", fetch = FetchType.LAZY)
    private Collection<Reception> expeditions;

    public Usine() {
    }

    public Usine(Integer idusine) {
        this.idusine = idusine;
    }

    public Integer getIdusine() {
        return idusine;
    }

    public void setIdusine(Integer idusine) {
        this.idusine = idusine;
    }

    public String getNomusine() {
        return nomusine;
    }

    public void setNomusine(String nomusine) {
        this.nomusine = nomusine;
    }

    public String getCodeusine() {
        return codeusine;
    }

    public void setCodeusine(String codeusine) {
        this.codeusine = codeusine;
    }

    @JsonIgnore
   	public Collection<Reception> getReceptions() {
   		return receptions;
   	}

   	public void setReceptions(Collection<Reception> receptions) {
   		this.receptions = receptions;
   	}

   	@JsonIgnore
   	public Collection<Reception> getExpeditions() {
   		return expeditions;
   	}

   	public void setExpeditions(Collection<Reception> expeditions) {
   		this.expeditions = expeditions;
   	}
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusine != null ? idusine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usine)) {
            return false;
        }
        Usine other = (Usine) object;
        if ((this.idusine == null && other.idusine != null) || (this.idusine != null && !this.idusine.equals(other.idusine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.Usine[ idusine=" + idusine + " ]";
    }

   
    
}
