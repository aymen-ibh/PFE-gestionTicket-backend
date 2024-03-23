package com.tn.saasProjectTicket.entity;

import java.util.Date;

public class ProjetCriteriaDTO {
	
	private Integer idManager;
	private Integer idClient;
    private Boolean isActif;
    private Date datedebutProjet;
    private Date dateFinProjet;
    private Date projetCreationDate;
    private String nomProjet;
   


	public Integer getIdManager() {
		return idManager;
	}


	public void setIdManager(Integer idManager) {
		this.idManager = idManager;
	}


	public Integer getIdClient() {
		return idClient;
	}


	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
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


	public ProjetCriteriaDTO(Integer idManager, Integer idClient, Boolean isActif, Date datedebutProjet,
			Date dateFinProjet, Date projetCreationDate, String nomProjet) {
		super();
		this.idManager = idManager;
		this.idClient = idClient;
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
