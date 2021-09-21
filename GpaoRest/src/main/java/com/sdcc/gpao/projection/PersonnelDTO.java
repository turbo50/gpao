package com.sdcc.gpao.projection;

public class PersonnelDTO {

	private String nom;
	private String matricule;
	
	public PersonnelDTO(String nom, String matricule) {
		super();
		this.nom = nom;
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
}
