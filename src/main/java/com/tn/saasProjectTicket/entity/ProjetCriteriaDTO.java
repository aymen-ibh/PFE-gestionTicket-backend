package com.tn.saasProjectTicket.entity;

import java.util.Date;

public class ProjetCriteriaDTO {
	
	private Integer clientId;
    private Boolean isActif;
    private Date datedebutProjet;
    private Date dateFinProjet;
    private Date projetCreationDate;
    private String nomProjet;
    
    
	public Integer getClientId() {
		return clientId;
	}


	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}


	public Boolean getIsActif() {
		return isActif;
	}


	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
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


	public String getNomProjet() {
		return nomProjet;
	}


	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}


	public ProjetCriteriaDTO(Integer clientId, Boolean isActif, Date datedebutProjet, Date dateFinProjet,
			Date projetCreationDate, String nomProjet) {
		super();
		this.clientId = clientId;
		this.isActif = isActif;
		this.datedebutProjet = datedebutProjet;
		this.dateFinProjet = dateFinProjet;
		this.projetCreationDate = projetCreationDate;
		this.nomProjet = nomProjet;
	}


	public ProjetCriteriaDTO() {
		super();
	}
    
    
}
