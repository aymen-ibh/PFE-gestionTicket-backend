package com.tn.saasProjectTicket.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.AuthResponse;
import com.tn.saasProjectTicket.entity.PasswordChangeDTO;
import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.entity.UtilisateurRegisterDTO;
import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;
import com.tn.saasProjectTicket.service.UserService;
import com.tn.saasProjectTicket.services.UserPrinciple;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		
	@PostMapping("/registerUser")
	public ResponseEntity<UtilisateurRegisterDTO> registerUser(@RequestBody UtilisateurRegisterDTO user) throws EmailAlreadyExistException,
	            UserAlreadyExistException{
		UtilisateurRegisterDTO newUser = userService.registerUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
	
	@PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserPrinciple userPrinciple) {
        try {
            return userService.authenticateUser(
                userPrinciple);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new AuthResponse(HttpStatus.UNAUTHORIZED.value(), null));
        }
    }
	
	@PostMapping("/forgot-password")
	public ResponseEntity<?> forgotPassword(@RequestParam("email") String email){
		this.userService.createResetToken(email);
		return ResponseEntity.ok().body(Map.of("message","Email de réinitialisation envoyé."));
	}
	
	@PostMapping("/reset-password")
	public ResponseEntity<?> resetPassword(@RequestParam("token") String token,
			                               @RequestParam("newPassword") String newPassword){
		this.userService.resetPassword(token, newPassword);
		return ResponseEntity.ok().body(Map.of("message","mot de passe réinitialisé avec succés!"));
	}
	
	@PostMapping("/{userId}/change-password")
	public ResponseEntity<?> changeUserPassword(@PathVariable Integer userId,@RequestBody PasswordChangeDTO passwordChangeDTO){
		try {
			userService.changeUserPassword(userId, passwordChangeDTO);
			return ResponseEntity.ok().body(Map.of("message","Mot de passe mis à jour avec succés"));
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/{userId}/role")
	public ResponseEntity<String> getUserRole(@PathVariable Integer userId){
		return new ResponseEntity<String>(this.userService.getUserRoleById(userId), HttpStatus.OK);
	}
	
}
