package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Ressource extends Employe {
	
	private boolean disponible;
	
	@OneToMany(mappedBy = "ressource" ,cascade = CascadeType.ALL)
	private Set<Ticket> tickets;

	@OneToMany(mappedBy = "ressource", cascade = CascadeType.ALL)
	private Set<CompetenceRessource> competencesAquis;
	
	public Ressource() {
		super();
	}

	public Ressource(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role, boolean isActif, String photo,
			Societe societe,Set<Ticket> tickets, Set<CompetenceRessource> competencesAquis, boolean disponible) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role, isActif, photo,
				societe);
		// TODO Auto-generated constructor stub
		this.tickets = tickets;
		this.competencesAquis = competencesAquis;
		this.disponible = disponible;

	}

	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public Set<CompetenceRessource> getCompetencesAquis() {
		return competencesAquis;
	}

	public void setCompetencesAquis(Set<CompetenceRessource> competencesAquis) {
		this.competencesAquis = competencesAquis;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Ressource [disponible=" + disponible + ", tickets=" + tickets + ", competencesAquis=" + competencesAquis
				+ "]";
	}

	
	
}
