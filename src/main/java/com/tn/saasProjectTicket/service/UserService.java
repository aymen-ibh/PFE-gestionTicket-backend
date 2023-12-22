package com.tn.saasProjectTicket.service;



import org.springframework.http.ResponseEntity;

import com.tn.saasProjectTicket.entity.AuthResponse;
import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.services.UserPrinciple;

public interface UserService {

	Utilisateur registerUser(Utilisateur utilisateur);
	ResponseEntity<AuthResponse> authenticateUser(UserPrinciple userPrinciple);
}
