package com.tn.saasProjectTicket.service;

import java.util.Date;

import com.tn.saasProjectTicket.entity.Utilisateur;

public interface UserService {

	Utilisateur registerUser(String firstName,String lastName,String username,
			                 String password,String email,Date birthDate);
}
