package com.tn.saasProjectTicket.entity;

import java.util.Date;
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
	
	


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Client(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role, boolean isActif) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role, isActif);
		// TODO Auto-generated constructor stub
	}


	public Client(Set<Projet> projets, Societe societe) {
		super();
		this.projets = projets;
		this.societe = societe;
	}


	@Override
	public String toString() {
		return "Client [projets=" + projets + ", societe=" + societe + "]";
	}
	
	

}
