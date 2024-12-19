package com.tn.saasProjectTicket.entity;

public class BudgetDTO {
	private Integer idSociete;
	private Integer idProjet;
	private Double budget;
	
	public BudgetDTO(Integer idSociete, Integer idProjet, Double budget) {
		super();
		this.idSociete = idSociete;
		this.idProjet = idProjet;
		this.budget = budget;
	}

	public Integer getIdSociete() {
		return idSociete;
	}
	public void setIdSociete(Integer idSociete) {
		this.idSociete = idSociete;
	}

	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Integer getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}
	
	
	
	
	
}
