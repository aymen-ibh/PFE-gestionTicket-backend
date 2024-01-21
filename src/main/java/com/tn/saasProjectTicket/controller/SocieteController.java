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

import com.tn.saasProjectTicket.entity.SocieteCriteriaDTO;
import com.tn.saasProjectTicket.entity.SocieteDTO;
import com.tn.saasProjectTicket.service.SocieteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/societe")
public class SocieteController {
	
	@Autowired
	private SocieteService societeService;
	
	@GetMapping
	public List<SocieteDTO> getAllSocieties(){
		return this.societeService.getAllSocities();
	}
	
	@GetMapping("/{idSociete}")
	public ResponseEntity<SocieteDTO> getSociete(@PathVariable int idSociete) {
		return new ResponseEntity<SocieteDTO>(this.societeService.getSociete(idSociete),HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<SocieteDTO>> filterSociete(@RequestBody SocieteCriteriaDTO criteria){
		List<SocieteDTO> filterList = this.societeService.findSocietyByCriteria(criteria);
		return ResponseEntity.ok(filterList);
	}

}
