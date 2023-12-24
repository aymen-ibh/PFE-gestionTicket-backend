package com.tn.saasProjectTicket.service;

import com.tn.saasProjectTicket.entity.Superviseur;
import com.tn.saasProjectTicket.entity.SuperviseurRegistrationDto;

public interface SuperviseurService {
	
	Superviseur registerSuperviseurEtSociete(SuperviseurRegistrationDto registrationDto);

}
