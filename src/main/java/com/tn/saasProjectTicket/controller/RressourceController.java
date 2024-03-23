package com.tn.saasProjectTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.ClientCriteriaDTO;
import com.tn.saasProjectTicket.entity.ClientDTO;
import com.tn.saasProjectTicket.entity.ManagerDTO;
import com.tn.saasProjectTicket.entity.RessourceCriteriaDTO;
import com.tn.saasProjectTicket.entity.RessourceDTO;
import com.tn.saasProjectTicket.service.RessourceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ressource")
public class RressourceController {

	@Autowired
	private RessourceService ressourceService;
	
	@GetMapping
	public List<RessourceDTO> getAllClients(){
		return this.ressourceService.getAllRessources();
	}
	
	@GetMapping("/{idRessource}")
	public ResponseEntity<RessourceDTO> getClient(@PathVariable int idRessource){
		return new ResponseEntity<RessourceDTO>(this.ressourceService.getRessource(idRessource),HttpStatus.OK);
	}
	
	@GetMapping("/ticket/{idTicket}")
	public ResponseEntity<List<RessourceDTO>> getRessourceByTicket(@PathVariable Integer idTicket){
		return new ResponseEntity<List<RessourceDTO>>(this.ressourceService.getRessourceByTicket(idTicket), HttpStatus.OK);
	}
	
	@GetMapping("/ticket/{idSociete}/{idTicket}")
	public ResponseEntity<List<RessourceDTO>> getRessourceNotAssignedToTicketBySociete(@PathVariable Integer idSociete,
			                                                                           @PathVariable Integer idTicket){
		return new ResponseEntity<List<RessourceDTO>>(this.ressourceService
				.getRessourceNotAssignedToTicketBySociete(idSociete, idTicket), HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<RessourceDTO>> filterClient(@RequestBody RessourceCriteriaDTO criteria){
		return new ResponseEntity<List<RessourceDTO>>(this.ressourceService.findRessourceByCriteria(criteria),HttpStatus.OK);
	}
	
}
