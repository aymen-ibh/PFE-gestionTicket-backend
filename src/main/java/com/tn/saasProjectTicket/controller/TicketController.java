package com.tn.saasProjectTicket.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/addTicket")
	public ResponseEntity<Ticket> ajouterTicket(@RequestBody Ticket ticket){
		return new ResponseEntity<Ticket>(ticketService.ajouterTicket(ticket),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateTicket/{idTicket}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket,@PathVariable int idTicket){
		return new ResponseEntity<Ticket>(ticketService.updateTicket(ticket, idTicket),HttpStatus.OK);
	}
	
	@GetMapping("{idTicket}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable int idTicket){
		return new ResponseEntity<Ticket>(ticketService.getTicket(idTicket),HttpStatus.OK);
	}
	
	@GetMapping
	public Set<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	@DeleteMapping("deleteTicket/{idTicket}")
	public ResponseEntity<String> deleteTicket(@PathVariable int idTicket){
		ticketService.deleteTicket(idTicket);
		return new ResponseEntity<String>("Ticket is deleted successfully!",HttpStatus.OK);
	}
}
