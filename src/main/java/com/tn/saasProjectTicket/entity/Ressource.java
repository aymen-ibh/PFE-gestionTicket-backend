package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Ressource extends Employe {
	
	@OneToMany(mappedBy = "ressource" ,cascade = CascadeType.ALL)
	private Set<Ticket> tickets;

	public Ressource() {
		super();
	}

	public Ressource(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role, boolean isActif, String photo) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role, isActif,
				photo);
		// TODO Auto-generated constructor stub
	}

	public Ressource(Set<Ticket> tickets) {
		super();
		this.tickets = tickets;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Ressource [tickets=" + tickets + "]";
	}

	
}
