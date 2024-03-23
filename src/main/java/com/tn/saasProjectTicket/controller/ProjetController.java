package com.tn.saasProjectTicket.controller;

import java.util.Date;
import java.util.List;
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
import com.tn.saasProjectTicket.entity.ProjetDTO;
import com.tn.saasProjectTicket.service.ProjetService;

@RestController
@RequestMapping("/projet")
public class ProjetController {
	
	@Autowired
	ProjetService projetService;
	
	@GetMapping
	public List<ProjetDTO> getAllProjects(){
		return this.projetService.getAllProjects();
	}
	
	@GetMapping("{idSociete}/myProjects")
	public ResponseEntity<List<ProjetDTO>> getSocieteProjets(@PathVariable int idSociete){
		return new ResponseEntity<List<ProjetDTO>>(this.projetService.getSocieteProjets(idSociete),HttpStatus.OK);
	}
	
	@GetMapping("{idClient}/clientProjects")
	public ResponseEntity<List<ProjetDTO>> getProjectsByClient(@PathVariable int idClient){
		return new ResponseEntity<List<ProjetDTO>>(this.projetService.getProjectsByClient(idClient),HttpStatus.OK);
	}
	
	@GetMapping("{idManager}/managerProjects")
	public ResponseEntity<List<ProjetDTO>> getProjectsByManager(@PathVariable int idManager){
		return new ResponseEntity<List<ProjetDTO>>(this.projetService.getProjectsByManager(idManager),HttpStatus.OK);
	}
	
	//ajout projet+affectation client et manager
	@PostMapping("/ajouterProjet")
    public ResponseEntity<?> ajouterProjet(
            @RequestBody Projet projet){
		return new ResponseEntity<>(projetService.ajouterProjet(projet), HttpStatus.CREATED);
	}
	
	@GetMapping("/{idProjet}")
	public ResponseEntity<ProjetDTO> afficherProjet(@PathVariable("idProjet") int id){
		return new ResponseEntity<ProjetDTO>(projetService.getProjetById(id),HttpStatus.OK);
	}

    @PostMapping("/search")
	public ResponseEntity<List<ProjetDTO>> findProjetsByCriteria(@RequestBody ProjetCriteriaDTO criteria) {
	    List<ProjetDTO> projets = projetService.findProjetsByCriteria(criteria);
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
