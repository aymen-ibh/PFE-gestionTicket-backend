package com.tn.saasProjectTicket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.Superviseur;
import com.tn.saasProjectTicket.entity.SuperviseurRegistrationDto;
import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;
import com.tn.saasProjectTicket.service.SuperviseurService;

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

}
