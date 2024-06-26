package com.tn.saasProjectTicket.service;

import com.tn.saasProjectTicket.entity.Employe;
import com.tn.saasProjectTicket.entity.Utilisateur;

public interface EmployeService {
	
	Utilisateur getEmploye(Integer userId);
}
