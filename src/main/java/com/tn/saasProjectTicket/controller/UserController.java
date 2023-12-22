package com.tn.saasProjectTicket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.saasProjectTicket.entity.AuthResponse;
import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;
import com.tn.saasProjectTicket.jwt.JwtProvider;
import com.tn.saasProjectTicket.service.UserService;
import com.tn.saasProjectTicket.services.UserPrinciple;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		
	@PostMapping("/registerUser")
	public ResponseEntity<Utilisateur> registerUser(@RequestBody Utilisateur user) throws EmailAlreadyExistException,
	            UserAlreadyExistException{
		Utilisateur newUser = userService.registerUser(user);
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
	
}
