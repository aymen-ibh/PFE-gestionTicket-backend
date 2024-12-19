package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.BudgetDTO;
import com.tn.saasProjectTicket.entity.TicketStatusDTO;
import com.tn.saasProjectTicket.enums.Etat;
import com.tn.saasProjectTicket.repository.TicketRepository;
import com.tn.saasProjectTicket.service.BIAPIService;

@Service
public class BIAPIServiceImpl implements BIAPIService {
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<TicketStatusDTO> getTicketCountForAllSociete() {
		return ticketRepository.getTicketCountForAllSociete()
	            .stream()
	            .map(result -> new TicketStatusDTO(
	                result[1].toString(),  // Status
	                (Long) result[2],     // Ticket Count
	                (Integer) result[0]   // idSociete
	            ))
	            .collect(Collectors.toList());
	}

	@Override
	public List<BudgetDTO> getBudgetsBySociete() {
		return ticketRepository.getBudgetBySocieteAndProjet()
	            .stream()
	            .map(result -> new BudgetDTO(
	                (Integer) result[0],   // idSociete
	                (Integer) result[1],   // idProjet
	                (Double) result[2]     // Total Budget
	            ))
	            .collect(Collectors.toList());
	}

}
