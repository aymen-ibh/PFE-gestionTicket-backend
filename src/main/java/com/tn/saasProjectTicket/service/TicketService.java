package com.tn.saasProjectTicket.service;

import java.util.List;
import java.util.Set;

import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.entity.RessourceDTO;
import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.entity.TicketCriteriaDTO;
import com.tn.saasProjectTicket.entity.TicketDTO;
import com.tn.saasProjectTicket.enums.Etat;

public interface TicketService {
	
	Ticket ajouterTicket(Integer idProjet, Ticket ticket);
	TicketDTO updateTicket(Ticket ticket,int idTicket);
	TicketDTO getTicket(int idTicket);
	List<TicketDTO> getTicketsByProjectAndEtat(Integer idProjet, Etat etat);
	void deleteTicket(int idTicket);
	Set<Ticket> findTicketsByCriteria(TicketCriteriaDTO criteria);
	TicketDTO assignRessourceToTicket(Integer idTicket, Integer idRessource);
	void unassignRessourceToTicket(Integer idTicket);
	
	List<TicketDTO> getTicketsByRessourceAndEtat(Integer idRessource, Etat etat);
	List<TicketDTO> getTicketsByManager(Integer idManager);
	List<TicketDTO> getTicketsByClient(Integer idClient); 
	List<RessourceDTO> suggestTopRessourcesForTicket(Integer ticketId);
}
