package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjetDTO {
	private Integer idProjet;
	private String nomProjet;
	private String descriptionProjet;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date datedebutProjet;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateFinProjet;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date projetCreationDate;
	private Date projetUpdateDate;
	private boolean isActif;
	@ManyToOne
	private ClientDTO client;
	@ManyToOne
	private ManagerDTO manager;
	@OneToMany
	private Set<Ticket> tickets;
	
	
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
	public boolean isActif() {
		return isActif;
	}
	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}
	public ClientDTO getClient() {
		return client;
	}
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	public ManagerDTO getManager() {
		return manager;
	}
	public void setManager(ManagerDTO manager) {
		this.manager = manager;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public ProjetDTO(Integer idProjet, String nomProjet, String descriptionProjet, Date datedebutProjet,
			Date dateFinProjet, Date projetCreationDate, Date projetUpdateDate, boolean isActif, ClientDTO client,
			ManagerDTO manager, Set<Ticket> tickets) {
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
	public ProjetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

  
    
	
    
    
}
