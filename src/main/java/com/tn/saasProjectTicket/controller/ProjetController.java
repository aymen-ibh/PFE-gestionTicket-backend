package com.tn.saasProjectTicket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.Projet;
import com.tn.saasProjectTicket.service.ProjetService;

@RestController
@RequestMapping("/projet")
public class ProjetController {
	
	@Autowired
	ProjetService projetService;
	
	//ajout projet+affectation client et manager
	@PostMapping("/ajouterProjet")
    public ResponseEntity<?> ajouterProjet(
            @RequestBody Projet projet){
		Projet newProjet = projetService.ajouterProjet(projet);
		return new ResponseEntity<>(newProjet, HttpStatus.CREATED);
	}

}
