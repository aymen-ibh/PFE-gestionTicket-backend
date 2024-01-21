package com.tn.saasProjectTicket.service;

import java.util.List;
import java.util.Set;

import com.tn.saasProjectTicket.entity.Superviseur;
import com.tn.saasProjectTicket.entity.SuperviseurCriteriaDTO;
import com.tn.saasProjectTicket.entity.SuperviseurRegistrationDto;

public interface SuperviseurService {
	
	Superviseur registerSuperviseurEtSociete(SuperviseurRegistrationDto registrationDto);
	List<SuperviseurRegistrationDto> getAllSuperviseur();
	SuperviseurRegistrationDto getSuperviseur(int idSuperviseur);
	void deleteSuperviseur(int idSuperviseur);
	SuperviseurRegistrationDto updateSuperviseur(SuperviseurRegistrationDto registrationDto,int isSuperviseur);
	List<SuperviseurRegistrationDto> findSuperviseurByCriteria(SuperviseurCriteriaDTO superviseurDto);
	SuperviseurRegistrationDto changerEtatSuperviseur(int idSuperviseur,boolean etatActif);
}
