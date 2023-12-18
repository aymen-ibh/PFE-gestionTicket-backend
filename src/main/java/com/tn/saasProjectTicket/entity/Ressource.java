package com.tn.saasProjectTicket.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Ressource extends Employe {
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Ticket> tickets;

	public Ressource() {
		super();
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
