package com.tn.saasProjectTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.Competence;
import com.tn.saasProjectTicket.service.CompetenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/skills")
public class CompetenceController {
	
	@Autowired
	private CompetenceService competenceService;
	
	@PostMapping("/create")
	public ResponseEntity<Competence> createCompetence(@RequestBody Competence competence){
		Competence newCompetence = this.competenceService.createCompetence(competence);
		return new ResponseEntity<Competence>(newCompetence, HttpStatus.CREATED);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Competence>> searchCompetences(@RequestParam String term){
		List<Competence> filteredCompetences = this.competenceService.searchCompetences(term);
		return new ResponseEntity<List<Competence>>(filteredCompetences, HttpStatus.OK);
	}

}
