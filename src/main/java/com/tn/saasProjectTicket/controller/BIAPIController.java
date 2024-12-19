package com.tn.saasProjectTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.BudgetDTO;
import com.tn.saasProjectTicket.entity.TicketStatusDTO;
import com.tn.saasProjectTicket.service.BIAPIService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bi-api")
public class BIAPIController {
	
	@Autowired
	private BIAPIService biapiService;
	
	@GetMapping("/ticketCountByStatus")
    public List<TicketStatusDTO> getTicketCountByStatus() {
        return biapiService.getTicketCountForAllSociete();
    }
	
	@GetMapping("/budgetBySocieteAndProjet")
	public List<BudgetDTO> getBudgetsBySociete() {
	    return biapiService.getBudgetsBySociete();
	}

}
