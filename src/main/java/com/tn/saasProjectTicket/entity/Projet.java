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

@Entity
public class Projet {
	
	@Id
	@GeneratedValue
	private Integer idProjet;
	private String nomProjet;
	private String descriptionProjet;
	private Date datedebutProjet;
	private Date dateFinProjet;
	private Date projetCreationDate;
	private Date projetUpdateDate;
	private boolean isActif;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Manager manager;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Ticket> tickets;
	
	public Projet() {
		super();
	}

	public Projet(Integer idProjet, String nomProjet, String descriptionProjet, Date datedebutProjet,
			Date dateFinProjet, Date projetCreationDate, Date projetUpdateDate,boolean isActif, Client client, Manager manager,
			Set<Ticket> tickets) {
		super();
		this.idProjet = idProjet;
		this.nomProjet = nomProjet;
		this.descriptionProjet = descriptionProjet;
		this.datedebutProjet = datedebutProjet;
		this.dateFinProjet = dateFinProjet;
		this.projetCreationDate = projetCreationDate;
		this.projetUpdateDate = projetUpdateDate;
		this.isActif = isActif;
		this.client = client;
		this.manager = manager;
		this.tickets = tickets;
	}

	public Integer getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getDescriptionProjet() {
		return descriptionProjet;
	}

	public void setDescriptionProjet(String descriptionProjet) {
		this.descriptionProjet = descriptionProjet;
	}

	public Date getDatedebutProjet() {
		return datedebutProjet;
	}

	public void setDatedebutProjet(Date datedebutProjet) {
		this.datedebutProjet = datedebutProjet;
	}

	public Date getDateFinProjet() {
		return dateFinProjet;
	}

	public void setDateFinProjet(Date dateFinProjet) {
		this.dateFinProjet = dateFinProjet;
	}

	public Date getProjetCreationDate() {
		return projetCreationDate;
	}

	public void setProjetCreationDate(Date projetCreationDate) {
		this.projetCreationDate = projetCreationDate;
	}

	public Date getProjetUpdateDate() {
		return projetUpdateDate;
	}

	public void setProjetUpdateDate(Date projetUpdateDate) {
		this.projetUpdateDate = projetUpdateDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", nomProjet=" + nomProjet + ", descriptionProjet=" + descriptionProjet
				+ ", datedebutProjet=" + datedebutProjet + ", dateFinProjet=" + dateFinProjet + ", projetCreationDate="
				+ projetCreationDate + ", projetUpdateDate=" + projetUpdateDate + ", isActif=" + isActif + ", client="
				+ client + ", manager=" + manager + ", tickets=" + tickets + "]";
	}

	
	
	

}
