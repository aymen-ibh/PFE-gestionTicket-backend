package com.tn.saasProjectTicket.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SuperviseurRegistrationDto {
	//Informations du superviseur:
	private int idSuperviseur;
	private String username;//
	private String password;//
	private String email;//
	private String firstName;//
	private String lastName;//
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate;
	private Date creationDate;
	private Date updateDate;
	private String role;
	private boolean isActif;
	
	//Informations du societe:
	private String nomSociete;//
	private String adresse;//
	private String secteurActivite;//
	private Date societeCreationDate;
	private Date societeUpdateDate;
	
	
	public SuperviseurRegistrationDto() {
		super();
	}
	
	public SuperviseurRegistrationDto(int id,String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role, boolean isActif, String nomSociete,
			String adresse, String secteurActivite, Date societeCreationDate, Date societeUpdateDate) {
		super();
		this.idSuperviseur = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.role = role;
		this.isActif = isActif;
		this.nomSociete = nomSociete;
		this.adresse = adresse;
		this.secteurActivite = secteurActivite;
		this.societeCreationDate = societeCreationDate;
		this.societeUpdateDate = societeUpdateDate;
	}


	
	public int getIdSuperviseur() {
		return idSuperviseur;
	}

	public void setIdSuperviseur(int idSuperviseur) {
		this.idSuperviseur = idSuperviseur;
	}

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
