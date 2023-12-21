package com.tn.saasProjectTicket.service;


import javax.naming.AuthenticationException;

import org.springframework.http.ResponseEntity;

import com.tn.saasProjectTicket.entity.AuthResponse;
import com.tn.saasProjectTicket.entity.Utilisateur;

public interface UserService {

	Utilisateur registerUser(Utilisateur utilisateur);
	ResponseEntity<AuthResponse> authenticateUser(String username, String password) throws
	            AuthenticationException;
}
