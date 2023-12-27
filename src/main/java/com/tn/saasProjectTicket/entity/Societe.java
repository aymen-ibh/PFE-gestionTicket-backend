package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Societe {
	
	@Id
	@GeneratedValue
	private Integer idSociete;
	private String nomSociete;
	private String adresse;
	private String secteurActivite;
	private Date societeCreationDate;
	private Date societeUpdateDate;
	
	@OneToOne(mappedBy = "societe",fetch = FetchType.LAZY)
	@JsonIgnore
	private Superviseur superviseur;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Client> clients;
	
	public Societe() {
		super();
	}

	public Societe(Integer idSociete, String nomSociete, String adresse, String secteurActivite,
			Date societeCreationDate, Date societeUpdateDate, Superviseur superviseur, Set<Client> clients) {
		super();
		this.idSociete = idSociete;
		this.nomSociete = nomSociete;
		this.adresse = adresse;
		this.secteurActivite = secteurActivite;
		this.societeCreationDate = societeCreationDate;
		this.societeUpdateDate = societeUpdateDate;
		this.superviseur = superviseur;
		this.clients = clients;
	}

	public Integer getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(Integer idSociete) {
		this.idSociete = idSociete;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public Date getSocieteCreationDate() {
		return societeCreationDate;
	}

	public void setSocieteCreationDate(Date societeCreationDate) {
		this.societeCreationDate = societeCreationDate;
	}

	public Date getSocieteUpdateDate() {
		return societeUpdateDate;
	}

	public void setSocieteUpdateDate(Date societeUpdateDate) {
		this.societeUpdateDate = societeUpdateDate;
	}

	public Superviseur getSuperviseur() {
		return superviseur;
	}

	public void setSuperviseur(Superviseur superviseur) {
		this.superviseur = superviseur;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Societe [idSociete=" + idSociete + ", nomSociete=" + nomSociete + ", adresse=" + adresse
				+ ", secteurActivite=" + secteurActivite + ", societeCreationDate=" + societeCreationDate
				+ ", societeUpdateDate=" + societeUpdateDate + ", superviseur=" + superviseur + ", clients=" + clients
				+ "]";
	}
	
	
	

}
