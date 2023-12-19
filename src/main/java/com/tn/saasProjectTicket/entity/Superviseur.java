package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Superviseur extends Utilisateur {
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Societe> societes;

	public Superviseur() {
		super();
	}

	public Superviseur(Set<Societe> societes) {
		super();
		this.societes = societes;
	}

	public Superviseur(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role);
		// TODO Auto-generated constructor stub
	}

	public Set<Societe> getSocietes() {
		return societes;
	}

	public void setSocietes(Set<Societe> societes) {
		this.societes = societes;
	}

	@Override
	public String toString() {
		return "Superviseur [societes=" + societes + "]";
	}
	
}
