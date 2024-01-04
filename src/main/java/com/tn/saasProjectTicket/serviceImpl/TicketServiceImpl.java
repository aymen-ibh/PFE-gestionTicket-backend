package com.tn.saasProjectTicket.serviceImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.TicketRepository;
import com.tn.saasProjectTicket.service.TicketService;

public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Ticket ajouterTicket(Ticket ticket) {
		Ticket newTicket = new Ticket();
		newTicket.setNomTicket(ticket.getNomTicket());
		newTicket.setDescriptionTicket(ticket.getDescriptionTicket());
		newTicket.setTicketCreationDate(new Date());
		newTicket.setTicketUpdateDate(new Date());
		ticketRepository.save(newTicket);
		return newTicket;
	}

	@Override
	public Ticket updateTicket(Ticket ticket, int idTicket) {
		Ticket ticketExistant = ticketRepository.findById(idTicket).get();
		ticketExistant.setNomTicket(ticket.getNomTicket());
		ticketExistant.setDescriptionTicket(ticket.getDescriptionTicket());
		ticketExistant.setTicketUpdateDate(new Date());
		ticketRepository.save(ticketExistant);
		return ticketExistant;
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
		ticketRepository.delete(ticket);
		
	}

}
