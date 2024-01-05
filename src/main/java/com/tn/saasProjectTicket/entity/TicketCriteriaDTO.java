package com.tn.saasProjectTicket.entity;

import java.util.Date;

import com.tn.saasProjectTicket.enums.Etat;

public class TicketCriteriaDTO {
	
	private Integer idTicket;
	private String nomTicket;
	private String descriptionTicket;
	private Etat etat;
	private Date startDate;
    private Date endDate;
	public Integer getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}
	public String getNomTicket() {
		return nomTicket;
	}
	public void setNomTicket(String nomTicket) {
		this.nomTicket = nomTicket;
	}
	public String getDescriptionTicket() {
		return descriptionTicket;
	}
	public void setDescriptionTicket(String descriptionTicket) {
		this.descriptionTicket = descriptionTicket;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public TicketCriteriaDTO() {
		super();
	}
	public TicketCriteriaDTO(Integer idTicket, String nomTicket, String descriptionTicket, Etat etat, Date startDate,
			Date endDate) {
		super();
		this.idTicket = idTicket;
		this.nomTicket = nomTicket;
		this.descriptionTicket = descriptionTicket;
		this.etat = etat;
		this.startDate = startDate;
		this.endDate = endDate;
	}
    
    

}
