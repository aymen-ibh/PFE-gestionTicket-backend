package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Societe {
	
	@Id
	@GeneratedValue
	private Integer idSociete;
	private String nomSociete;
	private String adresse;
	private String secteurActivite;
	private Date societeCreationDate;
	private Date societeUpdateDate;
	
	
	public Societe() {
		super();
	}

	public Societe(Integer idSociete, String nomSociete, String adresse, String secteurActivite, Date creationDate,
			Date updateDate) {
		super();
		this.idSociete = idSociete;
		this.nomSociete = nomSociete;
		this.adresse = adresse;
		this.secteurActivite = secteurActivite;
		this.societeCreationDate = creationDate;
		this.societeUpdateDate = updateDate;
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

	public Date getCreationDate() {
		return societeCreationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.societeCreationDate = creationDate;
	}

	public Date getUpdateDate() {
		return societeUpdateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.societeUpdateDate = updateDate;
	}
	
	
	
	

}
