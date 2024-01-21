package com.tn.saasProjectTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.ClientDTO;
import com.tn.saasProjectTicket.service.ClientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<ClientDTO> getAllClients(){
		return this.clientService.getAllClients();
	}
	
	@GetMapping("/{idClient}")
	public ResponseEntity<ClientDTO> getClient(@PathVariable int idClient){
		return new ResponseEntity<ClientDTO>(this.clientService.getClient(idClient),HttpStatus.OK);
	}
	
}
