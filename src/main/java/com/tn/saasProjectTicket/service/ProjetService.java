package com.tn.saasProjectTicket.service;

import java.util.List;
import java.util.Set;

import com.tn.saasProjectTicket.entity.Projet;
import com.tn.saasProjectTicket.entity.ProjetCriteriaDTO;
import com.tn.saasProjectTicket.entity.ProjetDTO;

public interface ProjetService {
	
	//add projet et l'affecter à un client et un manager
	List<ProjetDTO> getAllProjects();
	ProjetDTO ajouterProjet(Projet projet);
	ProjetDTO getProjetById(int idProjet);
	Projet updateProjet(Projet projet,int idProjet);
	List<ProjetDTO> findProjetsByCriteria(ProjetCriteriaDTO projetCriteriaDTO);
	Projet activerProjet(int idProjet);
	Projet desactiverProjet(int idProjet);
	
	List<ProjetDTO> getSocieteProjets(int idSociete);
	List<ProjetDTO> getProjectsByClient(int idClient);
	List<ProjetDTO> getProjectsByManager(int idManager);
}
