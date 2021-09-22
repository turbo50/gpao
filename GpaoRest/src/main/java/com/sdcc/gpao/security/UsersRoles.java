/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.security;

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
@Table(name = "users_roles")
@NamedQueries({
    @NamedQuery(name = "UsersRoles.findAll", query = "SELECT u FROM UsersRoles u"),
    @NamedQuery(name = "UsersRoles.findByIdUsersRoles", query = "SELECT u FROM UsersRoles u WHERE u.idUsersRoles = :idUsersRoles")})
public class UsersRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_users_roles")
    private Long idUsersRoles;
    @JoinColumn(name = "id_roles", referencedColumnName = "id_roles")
    @ManyToOne(optional = false)
    private Roles idRoles;
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", nullable = true)
    @ManyToOne(optional = true)
    private Users idUsers;

    public UsersRoles() {
    }

    public UsersRoles(Long idUsersRoles) {
        this.idUsersRoles = idUsersRoles;
    }
    
    public UsersRoles(Users idUsers, Roles idRoles) {
        this.idUsers = idUsers;
        this.idRoles = idRoles;
    }
    
    public UsersRoles(Roles idRoles) {
        this.idRoles = idRoles;
    }

    public Long getIdUsersRoles() {
        return idUsersRoles;
    }

    public void setIdUsersRoles(Long idUsersRoles) {
        this.idUsersRoles = idUsersRoles;
    }

    public Roles getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Roles idRoles) {
        this.idRoles = idRoles;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsersRoles != null ? idUsersRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersRoles)) {
            return false;
        }
        UsersRoles other = (UsersRoles) object;
        if ((this.idUsersRoles == null && other.idUsersRoles != null) || (this.idUsersRoles != null && !this.idUsersRoles.equals(other.idUsersRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.UsersRoles[ idUsersRoles=" + idUsersRoles + " ]";
    }
    
}
