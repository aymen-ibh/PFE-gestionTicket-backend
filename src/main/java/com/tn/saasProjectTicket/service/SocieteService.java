package com.tn.saasProjectTicket.service;

import java.util.List;

import com.tn.saasProjectTicket.entity.SocieteCriteriaDTO;
import com.tn.saasProjectTicket.entity.SocieteDTO;

public interface SocieteService {
	
	List<SocieteDTO> getAllSocities();
	SocieteDTO getSociete(int idSociete);
	List<SocieteDTO> findSocietyByCriteria(SocieteCriteriaDTO societeCriteria);
}
