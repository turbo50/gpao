/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "Reception")
@NamedQueries({
    @NamedQuery(name = "Reception.findAll", query = "SELECT r FROM Reception r"),
    @NamedQuery(name = "Reception.findByIdreception", query = "SELECT r FROM Reception r WHERE r.idreception = :idreception"),
    @NamedQuery(name = "Reception.findByDatereception", query = "SELECT r FROM Reception r WHERE r.datereception = :datereception"),
    @NamedQuery(name = "Reception.findByNumbordereau", query = "SELECT r FROM Reception r WHERE r.numbordereau = :numbordereau"),
    @NamedQuery(name = "Reception.findByNumvehicule", query = "SELECT r FROM Reception r WHERE r.numvehicule = :numvehicule"),
    @NamedQuery(name = "Reception.findByTransporteur", query = "SELECT r FROM Reception r WHERE r.transporteur = :transporteur"),
    @NamedQuery(name = "Reception.findByPoidsbruteexp", query = "SELECT r FROM Reception r WHERE r.poidsbruteexp = :poidsbruteexp"),
    @NamedQuery(name = "Reception.findByPoidnetexp", query = "SELECT r FROM Reception r WHERE r.poidnetexp = :poidnetexp"),
    @NamedQuery(name = "Reception.findByPoidsbrutrec", query = "SELECT r FROM Reception r WHERE r.poidsbrutrec = :poidsbrutrec"),
    @NamedQuery(name = "Reception.findByPoidsnetrec", query = "SELECT r FROM Reception r WHERE r.poidsnetrec = :poidsnetrec"),
    @NamedQuery(name = "Reception.findByDatesortie", query = "SELECT r FROM Reception r WHERE r.datesortie = :datesortie"),
    @NamedQuery(name = "Reception.findByHeuredebdech", query = "SELECT r FROM Reception r WHERE r.heuredebdech = :heuredebdech"),
    @NamedQuery(name = "Reception.findByHeurefindech", query = "SELECT r FROM Reception r WHERE r.heurefindech = :heurefindech"),
    @NamedQuery(name = "Reception.findByDatedech", query = "SELECT r FROM Reception r WHERE r.datedech = :datedech"),
    @NamedQuery(name = "Reception.findByNumcaisse1", query = "SELECT r FROM Reception r WHERE r.numcaisse1 = :numcaisse1"),
    @NamedQuery(name = "Reception.findByNumcaisse2", query = "SELECT r FROM Reception r WHERE r.numcaisse2 = :numcaisse2"),
    @NamedQuery(name = "Reception.findByTauxhumidite", query = "SELECT r FROM Reception r WHERE r.tauxhumidite = :tauxhumidite"),
    @NamedQuery(name = "Reception.findByTauxacidite", query = "SELECT r FROM Reception r WHERE r.tauxacidite = :tauxacidite"),
    @NamedQuery(name = "Reception.findByValidated", query = "SELECT r FROM Reception r WHERE r.validated = :validated")})
public class Reception implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_reception")
    private Integer idreception;
    @Basic(optional = false)
    @Column(name = "Date_reception")
    //@Temporal(TemporalType.DATE)
    private LocalDate datereception;
    @Basic(optional = false)
    @Column(name = "Num_bordereau")
    private String numbordereau;
    @Basic(optional = false)
    @Column(name = "Num_vehicule")
    private String numvehicule;
    @Column(name = "Transporteur")
    private String transporteur;
    @Basic(optional = false)
    @Column(name = "Poids_brute_exp")
    private int poidsbruteexp;
    @Column(name = "Poid_net_exp")
    private Integer poidnetexp;
    @Column(name = "Poids_brut_rec")
    private Integer poidsbrutrec;
    @Column(name = "Poids_net_rec")
    private Integer poidsnetrec;
    @Column(name = "Date_sortie")
    //@Temporal(TemporalType.DATE)
    private LocalDate datesortie;
    @Column(name = "Heure_deb_dech")
    //@Temporal(TemporalType.TIME)
    private LocalTime heuredebdech;
    @Column(name = "Heure_fin_dech")
    //@Temporal(TemporalType.TIME)
    private LocalTime heurefindech;
    @Column(name = "Date_dech")
    //@Temporal(TemporalType.DATE)
    private LocalDate datedech;
    @Column(name = "Num_caisse1")
    private String numcaisse1;
    @Column(name = "Num_caisse2")
    private String numcaisse2;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Taux_humidite")
    private Float tauxhumidite;
    @Column(name = "Taux_acidite")
    private Float tauxacidite;
    @Column(name = "Validated")
    private Boolean validated;
    @JoinColumn(name = "Id_chauffeur", referencedColumnName = "Id_chauffeur")
    @ManyToOne
    private Chauffeur idchauffeur;
    @JoinColumn(name = "Id_personnel", referencedColumnName = "Id_personnel")
    @ManyToOne
    private Personnel idpersonnel;
    @JoinColumn(name = "Id_usine_recep", referencedColumnName = "Id_usine")
    @ManyToOne(optional = false)
    private Usine idusinerecep;
    @JoinColumn(name = "Id_usine_exp", referencedColumnName = "Id_usine")
    @ManyToOne(optional = false)
    private Usine idusineexp;

    public Reception() {
    }

    public Reception(Integer idreception) {
        this.idreception = idreception;
    }

    public Reception(Integer idreception, LocalDate datereception, String numbordereau, String numvehicule, int poidsbruteexp) {
        this.idreception = idreception;
        this.datereception = datereception;
        this.numbordereau = numbordereau;
        this.numvehicule = numvehicule;
        this.poidsbruteexp = poidsbruteexp;
    }

    public Integer getIdreception() {
        return idreception;
    }

    public void setIdreception(Integer idreception) {
        this.idreception = idreception;
    }

    public LocalDate getDatereception() {
        return datereception;
    }

    public void setDatereception(LocalDate datereception) {
        this.datereception = datereception;
    }

    public String getNumbordereau() {
        return numbordereau;
    }

    public void setNumbordereau(String numbordereau) {
        this.numbordereau = numbordereau;
    }

    public String getNumvehicule() {
        return numvehicule;
    }

    public void setNumvehicule(String numvehicule) {
        this.numvehicule = numvehicule;
    }

    public String getTransporteur() {
        return transporteur;
    }

    public void setTransporteur(String transporteur) {
        this.transporteur = transporteur;
    }

    public int getPoidsbruteexp() {
        return poidsbruteexp;
    }

    public void setPoidsbruteexp(int poidsbruteexp) {
        this.poidsbruteexp = poidsbruteexp;
    }

    public Integer getPoidnetexp() {
        return poidnetexp;
    }

    public void setPoidnetexp(Integer poidnetexp) {
        this.poidnetexp = poidnetexp;
    }

    public Integer getPoidsbrutrec() {
        return poidsbrutrec;
    }

    public void setPoidsbrutrec(Integer poidsbrutrec) {
        this.poidsbrutrec = poidsbrutrec;
    }

    public Integer getPoidsnetrec() {
        return poidsnetrec;
    }

    public void setPoidsnetrec(Integer poidsnetrec) {
        this.poidsnetrec = poidsnetrec;
    }

    public LocalDate getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(LocalDate datesortie) {
        this.datesortie = datesortie;
    }

    public LocalTime getHeuredebdech() {
        return heuredebdech;
    }

    public void setHeuredebdech(LocalTime heuredebdech) {
        this.heuredebdech = heuredebdech;
    }

    public LocalTime getHeurefindech() {
        return heurefindech;
    }

    public void setHeurefindech(LocalTime heurefindech) {
        this.heurefindech = heurefindech;
    }

    public LocalDate getDatedech() {
        return datedech;
    }

    public void setDatedech(LocalDate datedech) {
        this.datedech = datedech;
    }

    public String getNumcaisse1() {
        return numcaisse1;
    }

    public void setNumcaisse1(String numcaisse1) {
        this.numcaisse1 = numcaisse1;
    }

    public String getNumcaisse2() {
        return numcaisse2;
    }

    public void setNumcaisse2(String numcaisse2) {
        this.numcaisse2 = numcaisse2;
    }

    public Float getTauxhumidite() {
        return tauxhumidite;
    }

    public void setTauxhumidite(Float tauxhumidite) {
        this.tauxhumidite = tauxhumidite;
    }

    public Float getTauxacidite() {
        return tauxacidite;
    }

    public void setTauxacidite(Float tauxacidite) {
        this.tauxacidite = tauxacidite;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Chauffeur getIdchauffeur() {
        return idchauffeur;
    }

    public void setIdchauffeur(Chauffeur idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    public Personnel getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(Personnel idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public Usine getIdusinerecep() {
        return idusinerecep;
    }

    public void setIdusinerecep(Usine idusinerecep) {
        this.idusinerecep = idusinerecep;
    }

    public Usine getIdusineexp() {
		return idusineexp;
	}

	public void setIdusineexp(Usine idusineexp) {
		this.idusineexp = idusineexp;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idreception != null ? idreception.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reception)) {
            return false;
        }
        Reception other = (Reception) object;
        if ((this.idreception == null && other.idreception != null) || (this.idreception != null && !this.idreception.equals(other.idreception))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sdcc.gpao.entity.Reception[ idreception=" + idreception + " ]";
    }
    
}
