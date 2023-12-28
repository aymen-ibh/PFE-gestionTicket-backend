package com.tn.saasProjectTicket.service;

import java.util.Set;

import com.tn.saasProjectTicket.entity.Projet;

public interface ProjetService {
	
	//add projet et l'affecter à un client et un manager
	Projet ajouterProjet(Projet projet);
	Projet getProjetById(int idProjet);
	Projet updateProjet(Projet projet,int idProjet);
	Set<Projet> getProjetsActifsParClient(int idClient);
	Projet activerProjet(int idProjet);
	Projet desactiverProjet(int idProjet);
}
