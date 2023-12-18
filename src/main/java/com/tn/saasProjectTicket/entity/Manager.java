package com.tn.saasProjectTicket.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Manager extends Employe {
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Projet> projets;

	public Manager() {
		super();
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
