package com.tn.saasProjectTicket.entity;

import java.util.Date;

public class SocieteCriteriaDTO {
	
	private Integer idSociete;
	private String nomSociete;
	private String adresse;
	private String secteurActivite;
	private Date societeCreationDate;
	private String usernameOwner;
	
	
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
	
	public String getUsernameOwner() {
		return usernameOwner;
	}
	public void setUsernameOwner(String usernameOwner) {
		this.usernameOwner = usernameOwner;
	}
	public SocieteCriteriaDTO() {
		super();
	}
	public SocieteCriteriaDTO(Integer idSociete, String nomSociete, String adresse, String secteurActivite,
			Date societeCreationDate, String ownerUsername) {
		super();
		this.idSociete = idSociete;
		this.nomSociete = nomSociete;
		this.adresse = adresse;
		this.secteurActivite = secteurActivite;
		this.societeCreationDate = societeCreationDate;
		this.usernameOwner = ownerUsername;
	}
	
	
}
