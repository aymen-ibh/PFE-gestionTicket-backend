package com.tn.saasProjectTicket.service;

import java.util.List;

import com.tn.saasProjectTicket.entity.BudgetDTO;
import com.tn.saasProjectTicket.entity.TicketStatusDTO;

public interface BIAPIService {
	
	List<TicketStatusDTO> getTicketCountForAllSociete();
	List<BudgetDTO> getBudgetsBySociete();

}
