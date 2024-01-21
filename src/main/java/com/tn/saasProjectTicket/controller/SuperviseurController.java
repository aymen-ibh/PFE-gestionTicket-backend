package com.tn.saasProjectTicket.controller;

import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;

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

import com.tn.saasProjectTicket.entity.Superviseur;
import com.tn.saasProjectTicket.entity.SuperviseurCriteriaDTO;
import com.tn.saasProjectTicket.entity.SuperviseurRegistrationDto;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;
import com.tn.saasProjectTicket.service.SuperviseurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseur")
public class SuperviseurController {
	
	@Autowired
	private SuperviseurService superviseurService;
	
	@PostMapping("/registerSuperviseur")
    public ResponseEntity<?> registerSuperviseurEtSociete(
            @RequestBody SuperviseurRegistrationDto registrationDto) {
        try {
            Superviseur newSuperviseur = superviseurService.registerSuperviseurEtSociete(registrationDto);
            return new ResponseEntity<>(newSuperviseur, HttpStatus.CREATED);
        } catch (EmailAlreadyExistException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Erreur : L'adresse email est déjà utilisée");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Erreur : Le nom d'utilisateur est déjà pris");
        } catch (Exception e) { // autre exception
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erreur interne du serveur");
        }
    }
	
	@GetMapping
	public List<SuperviseurRegistrationDto> afficherListSuperviseur(){
		return superviseurService.getAllSuperviseur();
	}
	
	@GetMapping("/{idSuperviseur}")
	public ResponseEntity<SuperviseurRegistrationDto> afficherSuperviseur(@PathVariable int idSuperviseur){
		return new ResponseEntity<SuperviseurRegistrationDto>(superviseurService.getSuperviseur(idSuperviseur), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{idSuperviseur}")
	public ResponseEntity<String> deleteSuperviseur(@PathVariable int idSuperviseur){
		superviseurService.deleteSuperviseur(idSuperviseur);
		return new ResponseEntity<String>("Supervisor is deleted successfully!", HttpStatus.OK);
	}
	
	@PutMapping("update/{idSuperviseur}")
	public ResponseEntity<SuperviseurRegistrationDto> updateSuperviseur(@RequestBody SuperviseurRegistrationDto superviseurDto,
			                                                            @PathVariable int idSuperviseur){
		return new ResponseEntity<SuperviseurRegistrationDto>(superviseurService.updateSuperviseur(superviseurDto, idSuperviseur),HttpStatus.OK);
	}
		

	
	@PostMapping("/search")
	public ResponseEntity<List<SuperviseurRegistrationDto>> filterSuperviseur(@RequestBody SuperviseurCriteriaDTO filter){
		List<SuperviseurRegistrationDto> superviseurs = superviseurService.findSuperviseurByCriteria(filter);
		return ResponseEntity.ok(superviseurs);
	}
	
	@PutMapping("/changeStatus/{idSuperviseur}")
	public ResponseEntity<SuperviseurRegistrationDto> changerEtatSuperviseur(@PathVariable int idSuperviseur,
			                                                  @RequestParam boolean etatActif){
		try {
            SuperviseurRegistrationDto superviseur = superviseurService.changerEtatSuperviseur(idSuperviseur, etatActif);
            return ResponseEntity.ok(superviseur);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
	}

}
