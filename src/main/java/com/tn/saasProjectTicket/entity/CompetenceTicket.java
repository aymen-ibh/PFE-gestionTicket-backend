package com.tn.saasProjectTicket.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tn.saasProjectTicket.enums.NiveauMaitrise;

@Entity
public class CompetenceTicket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCT;
	
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;
	@ManyToOne
	@JoinColumn(name = "competence_id")
	private Competence competence;
	
	@Enumerated(EnumType.STRING)
	private NiveauMaitrise niveauMaitrise;

	public CompetenceTicket() {
		super();
	}

	public CompetenceTicket(Integer idCT, Ticket ticket, Competence competence, NiveauMaitrise niveauMaitrise) {
		super();
		this.idCT = idCT;
		this.ticket = ticket;
		this.competence = competence;
		this.niveauMaitrise = niveauMaitrise;
	}

	public Integer getIdCT() {
		return idCT;
	}

	public void setIdCT(Integer idCT) {
		this.idCT = idCT;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public NiveauMaitrise getNiveauMaitrise() {
		return niveauMaitrise;
	}

	public void setNiveauMaitrise(NiveauMaitrise niveauMaitrise) {
		this.niveauMaitrise = niveauMaitrise;
	}

	@Override
	public String toString() {
		return "CompetenceTicket [idCT=" + idCT + ", ticket=" + ticket + ", competence=" + competence
				+ ", niveauMaitrise=" + niveauMaitrise + "]";
	}
	
	

}
