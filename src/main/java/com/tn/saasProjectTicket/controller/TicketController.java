package com.tn.saasProjectTicket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.entity.RessourceDTO;
import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.entity.TicketCriteriaDTO;
import com.tn.saasProjectTicket.entity.TicketDTO;
import com.tn.saasProjectTicket.enums.Etat;
import com.tn.saasProjectTicket.service.TicketService;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("{idProjet}/addTicket")
	public ResponseEntity<Ticket> ajouterTicket(@PathVariable Integer idProjet, @RequestBody Ticket ticket){
		return new ResponseEntity<Ticket>(ticketService.ajouterTicket(idProjet, ticket),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateTicket/{idTicket}")
	public ResponseEntity<TicketDTO> updateTicket(@RequestBody Ticket ticket,@PathVariable int idTicket){
		return new ResponseEntity<TicketDTO>(ticketService.updateTicket(ticket, idTicket),HttpStatus.OK);
	}
	
	@GetMapping("/{idTicket}")
	public ResponseEntity<TicketDTO> getTicketById(@PathVariable int idTicket){
		return new ResponseEntity<TicketDTO>(ticketService.getTicket(idTicket),HttpStatus.OK);
	}
	
	@GetMapping("/{idProjet}/listTickets")
	public List<TicketDTO> getTicketsByProject(@PathVariable Integer idProjet, @RequestParam("etat") String etat){
		return ticketService.getTicketsByProjectAndEtat(idProjet, Etat.valueOf(etat.toUpperCase()));
	}
	
	@DeleteMapping("deleteTicket/{idTicket}")
	public ResponseEntity<String> deleteTicket(@PathVariable int idTicket){
		ticketService.deleteTicket(idTicket);
		return new ResponseEntity<String>("Ticket is deleted successfully!",HttpStatus.OK);
	}
	
	@PutMapping("{idTicket}/assign/{idRessource}")
	public ResponseEntity<TicketDTO> assignRessourceToTicket(@PathVariable Integer idTicket,@PathVariable Integer idRessource){
		return new ResponseEntity<TicketDTO>(ticketService.assignRessourceToTicket(idTicket, idRessource),HttpStatus.OK);
	}
	
	@PutMapping("{idTicket}/unassign")
	public ResponseEntity<Map<String, String>> unassignRessourceFromTicket(@PathVariable Integer idTicket){
		ticketService.unassignRessourceToTicket(idTicket);
		Map<String, String> response = new HashMap<>();
	    response.put("message", "Ressource retracted from ticket!");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/search")
    public ResponseEntity<Set<Ticket>> getTickets(TicketCriteriaDTO filter) {
        Set<Ticket> tickets = ticketService.findTicketsByCriteria(filter);
        return ResponseEntity.ok(tickets);
    }
	
	@GetMapping("/byRessource/{idRessource}")
	public ResponseEntity<List<TicketDTO>> getTicketsByRessourceAndEtat(@PathVariable Integer idRessource, @RequestParam("etat") String etat){
		List<TicketDTO> tickets = ticketService.getTicketsByRessourceAndEtat(idRessource, Etat.valueOf(etat.toUpperCase()));
		return new ResponseEntity<List<TicketDTO>>(tickets, HttpStatus.OK);
	}
	
	@GetMapping("/byManager/{idManager}")
	public ResponseEntity<List<TicketDTO>> getTicketsByManager(@PathVariable Integer idManager){
		List<TicketDTO> tickets = ticketService.getTicketsByManager(idManager);
		return new ResponseEntity<List<TicketDTO>>(tickets, HttpStatus.OK);
	}
	
	@GetMapping("/byClient/{idClient}")
	public ResponseEntity<List<TicketDTO>> getTicketsByClient(@PathVariable Integer idClient){
		List<TicketDTO> tickets = ticketService.getTicketsByClient(idClient);
		return new ResponseEntity<List<TicketDTO>>(tickets, HttpStatus.OK);
	}
	
	@GetMapping("/{ticketId}/suggested-match")
	public ResponseEntity<List<RessourceDTO>> getSuggestedResources(@PathVariable Integer ticketId){
		List<RessourceDTO> ressources = ticketService.suggestTopRessourcesForTicket(ticketId);
		return new ResponseEntity<List<RessourceDTO>>(ressources, HttpStatus.OK);
	}
}
