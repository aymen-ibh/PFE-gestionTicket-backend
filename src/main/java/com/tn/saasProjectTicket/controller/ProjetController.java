package com.tn.saasProjectTicket.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.Projet;
import com.tn.saasProjectTicket.entity.ProjetCriteriaDTO;
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
		return new ResponseEntity<>(projetService.ajouterProjet(projet), HttpStatus.CREATED);
	}
	
	@GetMapping("afficherProjet/{idProjet}")
	public ResponseEntity<Projet> afficherProjet(@PathVariable("idProjet") int id){
		return new ResponseEntity<Projet>(projetService.getProjetById(id),HttpStatus.OK);
	}

    @GetMapping("/search")
	public ResponseEntity<Set<Projet>> findProjetsByCriteria(ProjetCriteriaDTO criteria) {
	    Set<Projet> projets = projetService.findProjetsByCriteria(criteria);
	    return ResponseEntity.ok(projets);
	}
	
	@PutMapping("{idProjet}/modifier")
	public ResponseEntity<Projet> modifierProjet(@RequestBody Projet projet,@PathVariable("idProjet") int id){
		return new ResponseEntity<Projet>(projetService.updateProjet(projet, id),HttpStatus.OK);
	}
	
	@PutMapping("/{projetId}/activer")
    public ResponseEntity<Projet> activerProjet(@PathVariable int projetId) {
        Projet projet = projetService.activerProjet(projetId);
        return new ResponseEntity<>(projet, HttpStatus.OK);
    }
	
	@PutMapping("/{projetId}/desactiver")
	public ResponseEntity<Projet> desactiverProjet(@PathVariable int projetId) {
        Projet projet = projetService.desactiverProjet(projetId);
        return new ResponseEntity<>(projet, HttpStatus.OK);
    }

}
