package com.tn.saasProjectTicket.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Historique {
	
	@Id
	@GeneratedValue
	private Integer idHistorique;
	private LocalDateTime dateHistorique; //date de l'action effectuée
	private String descriptionAction; //description detaillé de l'action effectuée
	private String ancienneValeur;
	private String nouvelleValeur;
	private String typeChangement;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Ticket ticket;

	
	public Historique() {
		super();
	}

	public Historique(Integer idHistorique, LocalDateTime dateHistorique, String descriptionAction,
			String ancienneValeur, String nouvelleValeur, String typeChangement, Ticket ticket) {
		super();
		this.idHistorique = idHistorique;
		this.dateHistorique = dateHistorique;
		this.descriptionAction = descriptionAction;
		this.ancienneValeur = ancienneValeur;
		this.nouvelleValeur = nouvelleValeur;
		this.typeChangement = typeChangement;
		this.ticket = ticket;
	}

	public Integer getIdHistorique() {
		return idHistorique;
	}

	public void setIdHistorique(Integer idHistorique) {
		this.idHistorique = idHistorique;
	}

	public LocalDateTime getDateHistorique() {
		return dateHistorique;
	}

	public void setDateHistorique(LocalDateTime dateHistorique) {
		this.dateHistorique = dateHistorique;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getDescriptionAction() {
		return descriptionAction;
	}

	public void setDescriptionAction(String descriptionAction) {
		this.descriptionAction = descriptionAction;
	}

	public String getAncienneValeur() {
		return ancienneValeur;
	}

	public void setAncienneValeur(String ancienneValeur) {
		this.ancienneValeur = ancienneValeur;
	}

	public String getNouvelleValeur() {
		return nouvelleValeur;
	}

	public void setNouvelleValeur(String nouvelleValeur) {
		this.nouvelleValeur = nouvelleValeur;
	}

	public String getTypeChangement() {
		return typeChangement;
	}

	public void setTypeChangement(String typeChangement) {
		this.typeChangement = typeChangement;
	}

	@Override
	public String toString() {
		return "Historique [idHistorique=" + idHistorique + ", dateHistorique=" + dateHistorique
				+ ", descriptionAction=" + descriptionAction + ", ancienneValeur=" + ancienneValeur
				+ ", nouvelleValeur=" + nouvelleValeur + ", typeChangement=" + typeChangement + ", ticket=" + ticket
				+ "]";
	}



}
