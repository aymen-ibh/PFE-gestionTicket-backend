package com.tn.saasProjectTicket.entity;

import java.util.Date;

public class SuperviseurRegistrationDto {
	//Informations du superviseur:
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Date creationDate;
	private Date updateDate;
	private String role;
	private boolean isActif;
	
	//Informations du societe:
	private String nomSociete;
	private String adresse;
	private String secteurActivite;
	private Date societeCreationDate;
	private Date societeUpdateDate;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActif() {
		return isActif;
	}
	public void setActif(boolean isActif) {
		this.isActif = isActif;
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
	
	
}
