package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Historique {
	
	@Id
	@GeneratedValue
	private Integer idHistorique;
	private Date dateHistorique;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Ticket ticket;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Etat> etats;
	
	public Historique() {
		super();
	}
	

	public Historique(Integer idHistorique, Date dateHistorique, Ticket ticket, Set<Etat> etats) {
		super();
		this.idHistorique = idHistorique;
		this.dateHistorique = dateHistorique;
		this.ticket = ticket;
		this.etats = etats;
	}


	public Integer getIdHistorique() {
		return idHistorique;
	}

	public void setIdHistorique(Integer idHistorique) {
		this.idHistorique = idHistorique;
	}

	public Date getDateHistorique() {
		return dateHistorique;
	}

	public void setDateHistorique(Date dateHistorique) {
		this.dateHistorique = dateHistorique;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Set<Etat> getEtats() {
		return etats;
	}

	public void setEtats(Set<Etat> etats) {
		this.etats = etats;
	}


	@Override
	public String toString() {
		return "Historique [idHistorique=" + idHistorique + ", dateHistorique=" + dateHistorique + ", ticket=" + ticket
				+ ", etats=" + etats + "]";
	}
	

}
