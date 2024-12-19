package com.tn.saasProjectTicket.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.CompetenceRessource;
import com.tn.saasProjectTicket.enums.NiveauMaitrise;
import com.tn.saasProjectTicket.service.CompetenceRessourceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ressourceSkills")
public class CompetenceRessourceController {
	
	@Autowired
    private CompetenceRessourceService competenceRessourceService;
	
	// 1. Ajouter une compétence
    @PostMapping("/add")
    public ResponseEntity<?> ajouterCompetence(@RequestBody Map<String, Object> payload) {
    	try {
        Integer ressourceId = (int) Long.parseLong(payload.get("ressourceId").toString());
        Integer competenceId = (int) Long.parseLong(payload.get("competenceId").toString());
        
        String niveauStr = payload.get("niveau").toString();
        NiveauMaitrise niveau = NiveauMaitrise.valueOf(niveauStr.toUpperCase());
        CompetenceRessource competenceRessource = competenceRessourceService.ajouterCompetence(ressourceId, competenceId, niveau);
        return ResponseEntity.ok(competenceRessource);
    	}catch (IllegalArgumentException e) {
    		return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
    
 // 2. Valider ou refuser une compétence
    @PutMapping("/validate")
    public ResponseEntity<CompetenceRessource> validerCompetence(@RequestBody Map<String, Object> payload) {
        Integer competenceRessourceId = (int) Long.parseLong(payload.get("competenceRessourceId").toString());
        String statutValidation = payload.get("statut_validation").toString();
        String commentaire = payload.get("commentaire").toString();
        CompetenceRessource competenceRessource = competenceRessourceService.validerCompetence(competenceRessourceId, statutValidation, commentaire);
        return ResponseEntity.ok(competenceRessource);
    }
    
    // 3. Lister les compétences d'une ressource
    @GetMapping("/ressource/{ressourceId}")
    public ResponseEntity<List<CompetenceRessource>> listerCompetences(@PathVariable Integer ressourceId) {
        return ResponseEntity.ok(competenceRessourceService.listerCompetencesParRessource(ressourceId));
    }

    // 4. Lister les compétences en attente
    @GetMapping("/pending")
    public ResponseEntity<List<CompetenceRessource>> listerCompetencesEnAttente() {
        return ResponseEntity.ok(competenceRessourceService.listerCompetencesEnAttente());
    }
    
    // 5. Modifier la competenceRessource : statut devient 'en attente'
    @PutMapping("/update/{idCR}")
    public ResponseEntity<CompetenceRessource> updateCompetenceRessource(
    		@PathVariable Integer idCR, @RequestBody Map<String, String> payload){
    	String nouveauNiveau = payload.get("niveauMaitrise");
    	CompetenceRessource updatedCompetenceRessource = competenceRessourceService.updateCompetenceRessource(idCR, nouveauNiveau);
    	return ResponseEntity.ok(updatedCompetenceRessource);
    }
    
    // 6. Supprimer une competenceRessource
    @DeleteMapping("/delete/{idCR}")
    public ResponseEntity<String> deleteCompetenceRessource(@PathVariable Integer idCR){
    	competenceRessourceService.supprimerCompetenceRessource(idCR);
    	return ResponseEntity.noContent().build(); // pour retourner 204 No Content
    }
    
    // 7. afficher les competenceRessource en Attente
    @GetMapping("/{idSociete}/pending")
    public ResponseEntity<List<CompetenceRessource>> getCompetencesEnAttente(@PathVariable Integer idSociete){
    	List<CompetenceRessource> competences = competenceRessourceService
    			.getCompetencesRessourceEnAttenteBySociete(idSociete);
    	return ResponseEntity.ok(competences);
    }
    
    // 8. update le statutValidation des competences
    @PutMapping("/validate/{idCR}")
    public ResponseEntity<CompetenceRessource> updateStatutValidation(
    		@PathVariable Integer idCR,@RequestBody Map<String, String> payload){
    	String statutValidation = payload.get("statutValidation");
    	CompetenceRessource updatedCompetenceRessource = competenceRessourceService.updateStatutValidation(idCR, statutValidation);
    	return ResponseEntity.ok(updatedCompetenceRessource);
    }

}
