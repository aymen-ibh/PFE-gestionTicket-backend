package com.tn.saasProjectTicket.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tn.saasProjectTicket.enums.NiveauMaitrise;

@Entity
public class CompetenceRessource {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCR;
	
	@ManyToOne
	@JoinColumn(name = "ressource_id")
	@JsonIgnore
	private Ressource ressource;
	@ManyToOne
	@JoinColumn(name = "competence_id")
	private Competence competence;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "niveau_maitrise", nullable = false)
	private NiveauMaitrise niveauMaitrise;
	
	private String statutValidation;  // "En attente", "Validée", "Refusée"
	private String commentaire;
	
	@JsonInclude
	public Map<String, String> getRessourceDetails() {
	    if (ressource == null) {
	        return null;
	    }
	    return Map.of(
	        "firstName", ressource.getFirstName(),
	        "lastName", ressource.getLastName()
	    );
	}

	public CompetenceRessource() {
		super();
	}

	public CompetenceRessource(Integer idCR, Ressource ressource, Competence competence, NiveauMaitrise niveauMaitrise,
			String statutValidation, String commentaire) {
		super();
		this.idCR = idCR;
		this.ressource = ressource;
		this.competence = competence;
		this.niveauMaitrise = niveauMaitrise;
		this.statutValidation = statutValidation;
		this.commentaire = commentaire;
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

	public String getStatutValidation() {
		return statutValidation;
	}

	public void setStatutValidation(String statutValidation) {
		this.statutValidation = statutValidation;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "CompetenceRessource [idCR=" + idCR + ", ressource=" + ressource + ", competence=" + competence
				+ ", niveauMaitrise=" + niveauMaitrise + ", statutValidation=" + statutValidation + ", commentaire="
				+ commentaire + "]";
	}

	
	
}
