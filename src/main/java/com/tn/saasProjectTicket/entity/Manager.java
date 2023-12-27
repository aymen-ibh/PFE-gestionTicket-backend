package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Manager extends Employe {
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Projet> projets;

	public Manager() {
		super();
	}
	

	public Manager(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role, boolean isActif) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role, isActif);
		// TODO Auto-generated constructor stub
	}


	public Manager(Set<Projet> projets) {
		super();
		this.projets = projets;
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public String toString() {
		return "Manager [projets=" + projets + "]";
	}
	
}
