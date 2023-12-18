package com.tn.saasProjectTicket.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Etat {
	
	@Id
	@GeneratedValue
	private Integer idEtat;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Historique> historiques;
	
	
	public Etat() {
		super();
	}

	public Etat(Integer idEtat, Set<Historique> historiques) {
		super();
		this.idEtat = idEtat;
		this.historiques = historiques;
	}

	public Integer getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(Integer idEtat) {
		this.idEtat = idEtat;
	}

	public Set<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(Set<Historique> historiques) {
		this.historiques = historiques;
	}

	@Override
	public String toString() {
		return "Etat [idEtat=" + idEtat + ", historiques=" + historiques + "]";
	}
	
	
}
