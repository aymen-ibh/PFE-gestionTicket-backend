package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import com.tn.saasProjectTicket.enums.Currency;
import com.tn.saasProjectTicket.enums.Etat;

public class TicketDTO {
	
	private Integer idTicket;
	private String nomTicket;
	private String descriptionTicket;
	private Etat etat;
	private Date ticketCreationDate;
	private Date ticketUpdateDate;
	private Double budget;
	private Currency currency;
	private RessourceDTO ressource;
	private ProjetDTO projet;
	private Set<HistoriqueDTO> historiques;
	public Integer getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}
	public String getNomTicket() {
		return nomTicket;
	}
	public void setNomTicket(String nomTicket) {
		this.nomTicket = nomTicket;
	}
	public String getDescriptionTicket() {
		return descriptionTicket;
	}
	public void setDescriptionTicket(String descriptionTicket) {
		this.descriptionTicket = descriptionTicket;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Date getTicketCreationDate() {
		return ticketCreationDate;
	}
	public void setTicketCreationDate(Date ticketCreationDate) {
		this.ticketCreationDate = ticketCreationDate;
	}
	public Date getTicketUpdateDate() {
		return ticketUpdateDate;
	}
	public void setTicketUpdateDate(Date ticketUpdateDate) {
		this.ticketUpdateDate = ticketUpdateDate;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public RessourceDTO getRessource() {
		return ressource;
	}
	public void setRessource(RessourceDTO ressource) {
		this.ressource = ressource;
	}
	public ProjetDTO getProjet() {
		return projet;
	}
	public void setProjet(ProjetDTO projet) {
		this.projet = projet;
	}
	public Set<HistoriqueDTO> getHistoriques() {
		return historiques;
	}
	public void setHistoriques(Set<HistoriqueDTO> historiques) {
		this.historiques = historiques;
	}
	
	
	public TicketDTO() {
		super();
	}
	public TicketDTO(Integer idTicket, String nomTicket, String descriptionTicket, Etat etat, Date ticketCreationDate,
			Date ticketUpdateDate,Double budget,Currency currency, RessourceDTO ressource, ProjetDTO projet, Set<HistoriqueDTO> historiques) {
		super();
		this.idTicket = idTicket;
		this.nomTicket = nomTicket;
		this.descriptionTicket = descriptionTicket;
		this.etat = etat;
		this.ticketCreationDate = ticketCreationDate;
		this.ticketUpdateDate = ticketUpdateDate;
		this.budget = budget;
		this.currency = currency;
		this.ressource = ressource;
		this.projet = projet;
		this.historiques = historiques;
	}

	
}
