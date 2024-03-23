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

import com.tn.saasProjectTicket.entity.ManagerCriteriaDTO;
import com.tn.saasProjectTicket.entity.ManagerDTO;
import com.tn.saasProjectTicket.service.ManagerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping
	public List<ManagerDTO> getAllClients(){
		return this.managerService.getAllManagers();
	}
	
	@GetMapping("/{idManager}")
	public ResponseEntity<ManagerDTO> getManager(@PathVariable int idManager){
		return new ResponseEntity<ManagerDTO>(this.managerService.getManager(idManager),HttpStatus.OK);
	}
	
	@GetMapping("/{idSociete}/managers")
	public ResponseEntity<List<ManagerDTO>> getManagersBySociete(@PathVariable int idSociete){
		return new ResponseEntity<List<ManagerDTO>>(this.managerService.getManagersBySociete(idSociete),HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<ManagerDTO>> filterManager(@RequestBody ManagerCriteriaDTO criteria){
		return new ResponseEntity<List<ManagerDTO>>(this.managerService.findManagerByCriteria(criteria),HttpStatus.OK);
	}

}
