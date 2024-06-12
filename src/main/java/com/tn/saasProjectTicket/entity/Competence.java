package com.tn.saasProjectTicket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Competence {
	
	@Id
	@GeneratedValue
	private Integer idCompetence;
	
	private String nom;

	public Competence() {
		super();
	}

	public Competence(Integer idCompetence, String nom) {
		super();
		this.idCompetence = idCompetence;
		this.nom = nom;
	}

	public Integer getIdCompetence() {
		return idCompetence;
	}

	public void setIdCompetence(Integer idCompetence) {
		this.idCompetence = idCompetence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Competence [idCompetence=" + idCompetence + ", nom=" + nom + "]";
	}
	
	
	

}
