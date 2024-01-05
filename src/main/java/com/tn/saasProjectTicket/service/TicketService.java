package com.tn.saasProjectTicket.service;

import java.util.Set;

import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.entity.TicketCriteriaDTO;

public interface TicketService {
	
	Ticket ajouterTicket(Ticket ticket);
	Ticket updateTicket(Ticket ticket,int idTicket);
	Ticket getTicket(int idTicket);
	Set<Ticket> getAllTickets();
	void deleteTicket(int idTicket);
	Set<Ticket> findTicketsByCriteria(TicketCriteriaDTO criteria);
}
