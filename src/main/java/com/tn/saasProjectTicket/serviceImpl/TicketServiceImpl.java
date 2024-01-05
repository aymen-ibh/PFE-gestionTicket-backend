package com.tn.saasProjectTicket.serviceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Historique;
import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.entity.TicketCriteriaDTO;
import com.tn.saasProjectTicket.enums.Etat;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.HistoriqueRepository;
import com.tn.saasProjectTicket.repository.TicketRepository;
import com.tn.saasProjectTicket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	HistoriqueRepository historiqueRepository;

	@Override
	public Ticket ajouterTicket(Ticket ticket) {
		Ticket newTicket = new Ticket();
		newTicket.setNomTicket(ticket.getNomTicket());
		newTicket.setDescriptionTicket(ticket.getDescriptionTicket());
		newTicket.setTicketCreationDate(new Date());
		newTicket.setTicketUpdateDate(new Date());
		newTicket.setEtat(Etat.TO_DO);
		ticketRepository.save(newTicket);
		
		addHistory(newTicket, "Ticket créé","CREATION", null, newTicket.toString());
		
		return newTicket;
	}

	@Override
	public Ticket updateTicket(Ticket ticket, int idTicket) {
		Ticket ticketExistant = ticketRepository.findById(idTicket).get();
		String oldData = ticketExistant.toString();
		ticketExistant.setNomTicket(ticket.getNomTicket());
		ticketExistant.setDescriptionTicket(ticket.getDescriptionTicket());
		ticketExistant.setTicketUpdateDate(new Date());
		Ticket updatedTicket = ticketRepository.save(ticketExistant);
		
		addHistory(ticketExistant, "Ticket mis à jour", "MODIFICATION", oldData, updatedTicket.toString());
		
		return updatedTicket;
	}

	@Override
	public Ticket getTicket(int idTicket) {
		return ticketRepository.findById(idTicket).orElseThrow(
				()->new RessourceNotFoundException("Ticket","Id",idTicket)
				);
	}

	@Override
	public Set<Ticket> getAllTickets() {
		List<Ticket> ticketList = ticketRepository.findAll();
	    return new HashSet<>(ticketList);
	}

	@Override
	public void deleteTicket(int idTicket) {
		Ticket ticket = ticketRepository.findById(idTicket).orElseThrow(
				()->new RessourceNotFoundException("Ticket","Id",idTicket)
				);
		addHistory(ticket, "Ticket supprimé", "SUPPRESSION", ticket.toString(), null);
		ticketRepository.delete(ticket);
		
	}
	

	private void addHistory(Ticket ticket, String action,String typeChangement, String oldValue, String newValue) {
		Historique history = new Historique();
		history.setTicket(ticket);
		history.setDateHistorique(LocalDateTime.now());
		history.setDescriptionAction(action);
		history.setAncienneValeur(oldValue);
		history.setNouvelleValeur(newValue);
		history.setTypeChangement(typeChangement);
		historiqueRepository.save(history);
	}

	@Override
	public Set<Ticket> findTicketsByCriteria(TicketCriteriaDTO criteria) {
		
		return ticketRepository.findByCriteria(
				criteria.getIdTicket(),
				criteria.getNomTicket(),
				criteria.getDescriptionTicket(),
				criteria.getEtat(),
				criteria.getStartDate(),
				criteria.getEndDate()
				);
	}

}
