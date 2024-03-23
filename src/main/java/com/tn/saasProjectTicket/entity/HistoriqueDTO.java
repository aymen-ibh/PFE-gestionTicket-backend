package com.tn.saasProjectTicket.entity;

import java.time.LocalDateTime;

public class HistoriqueDTO {
	
	private Integer idHistorique;
	private LocalDateTime dateHistorique; //date de l'action effectuée
	private String descriptionAction; //description detaillé de l'action effectuée
	private String ancienneValeur;
	private String nouvelleValeur;
	private String typeChangement;
	private TicketDTO ticket;
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
	public TicketDTO getTicket() {
		return ticket;
	}
	public void setTicket(TicketDTO ticket) {
		this.ticket = ticket;
	}
	public HistoriqueDTO() {
		super();
	}
	public HistoriqueDTO(Integer idHistorique, LocalDateTime dateHistorique, String descriptionAction,
			String ancienneValeur, String nouvelleValeur, String typeChangement, TicketDTO ticket) {
		super();
		this.idHistorique = idHistorique;
		this.dateHistorique = dateHistorique;
		this.descriptionAction = descriptionAction;
		this.ancienneValeur = ancienneValeur;
		this.nouvelleValeur = nouvelleValeur;
		this.typeChangement = typeChangement;
		this.ticket = ticket;
	}
	
	
	
}
