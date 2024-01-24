package com.tn.saasProjectTicket.service;

import java.util.List;

import com.tn.saasProjectTicket.entity.RessourceCriteriaDTO;
import com.tn.saasProjectTicket.entity.RessourceDTO;

public interface RessourceService {

	List<RessourceDTO> getAllRessources();
	RessourceDTO getRessource(int idRessource);
	List<RessourceDTO> findRessourceByCriteria(RessourceCriteriaDTO criteria);
}
