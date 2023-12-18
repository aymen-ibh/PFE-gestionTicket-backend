package com.tn.saasProjectTicket.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Client extends Utilisateur {
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Projet> projets;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Societe societe;
	
	
	public Client() {
		super();
	}


	public Client(Set<Projet> projets, Societe societe) {
		super();
		this.projets = projets;
		this.societe = societe;
	}


	public Set<Projet> getProjets() {
		return projets;
	}


	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}


	public Societe getSociete() {
		return societe;
	}


	public void setSociete(Societe societe) {
		this.societe = societe;
	}


	@Override
	public String toString() {
		return "Client [projets=" + projets + ", societe=" + societe + "]";
	}
	
	

}
