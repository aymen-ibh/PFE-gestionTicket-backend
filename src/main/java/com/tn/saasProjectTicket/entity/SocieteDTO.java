package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Lob;

public class SocieteDTO {
	//info societe
	private Integer idSociete;
	private String nomSociete;
	private String adresse;
	private String secteurActivite;
	private Date societeCreationDate;
	private Date societeUpdateDate;
	@Lob
	private String photo;
	
	//info owner(superviseur)
	private String firstNameOwner;
	private String lastNameOwner;
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
	public Date getSocieteUpdateDate() {
		return societeUpdateDate;
	}
	public void setSocieteUpdateDate(Date societeUpdateDate) {
		this.societeUpdateDate = societeUpdateDate;
	}
	public String getFirstNameOwner() {
		return firstNameOwner;
	}
	public void setFirstNameOwner(String firstNameOwner) {
		this.firstNameOwner = firstNameOwner;
	}
	public String getLastNameOwner() {
		return lastNameOwner;
	}
	public void setLastNameOwner(String lastNameOwner) {
		this.lastNameOwner = lastNameOwner;
	}
	public String getUsernameOwner() {
		return usernameOwner;
	}
	public void setUsernameOwner(String usernameOwner) {
		this.usernameOwner = usernameOwner;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public SocieteDTO() {
		super();
	}
	public SocieteDTO(Integer idSociete, String nomSociete, String adresse, String secteurActivite,
			Date societeCreationDate, Date societeUpdateDate, String firstNameOwner, String lastNameOwner,
			String usernameOwner, String photo) {
		super();
		this.idSociete = idSociete;
		this.nomSociete = nomSociete;
		this.adresse = adresse;
		this.secteurActivite = secteurActivite;
		this.societeCreationDate = societeCreationDate;
		this.societeUpdateDate = societeUpdateDate;
		this.firstNameOwner = firstNameOwner;
		this.lastNameOwner = lastNameOwner;
		this.usernameOwner = usernameOwner;
		this.photo = photo;
	}
	
	
}
