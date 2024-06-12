package com.tn.saasProjectTicket.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tn.saasProjectTicket.enums.NiveauMaitrise;

@Entity
public class CompetenceRessource {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCR;
	
	@ManyToOne
	@JoinColumn(name = "ressource_id")
	private Ressource ressource;
	@ManyToOne
	@JoinColumn(name = "competence_id")
	private Competence competence;
	
	@Enumerated(EnumType.STRING)
	private NiveauMaitrise niveauMaitrise;

	public CompetenceRessource() {
		super();
	}

	public CompetenceRessource(Integer idCR, Ressource ressource, Competence competence, NiveauMaitrise niveauMaitrise) {
		super();
		this.idCR = idCR;
		this.ressource = ressource;
		this.competence = competence;
		this.niveauMaitrise = niveauMaitrise;
	}

	public Integer getIdCR() {
		return idCR;
	}

	public void setIdCR(Integer idCR) {
		this.idCR = idCR;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public NiveauMaitrise getNiveauMaitrise() {
		return niveauMaitrise;
	}

	public void setNiveauMaitrise(NiveauMaitrise niveauMaitrise) {
		this.niveauMaitrise = niveauMaitrise;
	}

	@Override
	public String toString() {
		return "CompetenceRessource [idCR=" + idCR + ", ressource=" + ressource + ", competence=" + competence
				+ ", niveauMaitrise=" + niveauMaitrise + "]";
	}
	
	
}
