package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tn.saasProjectTicket.enums.Etat;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue
	private Integer idTicket;
	private String nomTicket;
	private String descriptionTicket;
	private Etat etat;
	private Date ticketCreationDate;
	private Date ticketUpdateDate;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Ressource ressource;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Projet projet;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Historique> historiques;
	
	public Ticket() {
		super();
	}

	public Ticket(Integer idTicket, String nomTicket, String descriptionTicket, Date ticketCreationDate,
			Date ticketUpdateDate, Ressource ressource, Projet projet, Set<Historique> historiques) {
		super();
		this.idTicket = idTicket;
		this.nomTicket = nomTicket;
		this.descriptionTicket = descriptionTicket;
		this.etat = Etat.TO_DO;
		this.ticketCreationDate = ticketCreationDate;
		this.ticketUpdateDate = ticketUpdateDate;
		this.ressource = ressource;
		this.projet = projet;
		this.historiques = historiques;
	}

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

	public Date getTicketCreationDate() {
		return ticketCreationDate;
	}

	public void setTicketCreationDate(Date ticketCreationDate) {
		this.ticketCreationDate = ticketCreationDate;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Date getTicketUpdateDate() {
		return ticketUpdateDate;
	}

	public void setTicketUpdateDate(Date ticketUpdateDate) {
		this.ticketUpdateDate = ticketUpdateDate;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Set<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(Set<Historique> historiques) {
		this.historiques = historiques;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", nomTicket=" + nomTicket + ", descriptionTicket=" + descriptionTicket
				+ ", etat=" + etat + ", ticketCreationDate=" + ticketCreationDate + ", ticketUpdateDate="
				+ ticketUpdateDate + ", ressource=" + ressource + ", projet=" + projet + ", historiques=" + historiques
				+ "]";
	}

	
	

}
