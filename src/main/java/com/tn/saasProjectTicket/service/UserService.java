package com.tn.saasProjectTicket.service;



import org.springframework.http.ResponseEntity;

import com.tn.saasProjectTicket.entity.AuthResponse;
import com.tn.saasProjectTicket.entity.PasswordChangeDTO;
import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.entity.UtilisateurRegisterDTO;
import com.tn.saasProjectTicket.services.UserPrinciple;

public interface UserService {

	UtilisateurRegisterDTO registerUser(UtilisateurRegisterDTO utilisateur);
	ResponseEntity<AuthResponse> authenticateUser(UserPrinciple userPrinciple);
	
	void createResetToken(String email);
	void resetPassword(String token, String newPassword);
	boolean changeUserPassword(Integer userId, PasswordChangeDTO passwordChangeDTO);
}
