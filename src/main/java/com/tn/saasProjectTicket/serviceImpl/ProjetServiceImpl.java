package com.tn.saasProjectTicket.serviceImpl;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Client;
import com.tn.saasProjectTicket.entity.Manager;
import com.tn.saasProjectTicket.entity.Projet;
import com.tn.saasProjectTicket.repository.ClientRepository;
import com.tn.saasProjectTicket.repository.ManagerRepository;
import com.tn.saasProjectTicket.repository.ProjetRepository;
import com.tn.saasProjectTicket.service.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {
	
	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ManagerRepository managerRepository;

	@Override
	public Projet ajouterProjet(Projet projet) {
		Projet newProjet = new Projet();
		newProjet.setNomProjet(projet.getNomProjet());
		newProjet.setDescriptionProjet(projet.getDescriptionProjet());
		newProjet.setProjetCreationDate(new Date());
		newProjet.setProjetUpdateDate(new Date());
		newProjet.setDatedebutProjet(new Date());
		newProjet.setDateFinProjet(projet.getDateFinProjet());
		newProjet.setActif(false);
		
		int idClient = projet.getClient().getUserId();
		int idManager = projet.getManager().getUserId();
		Client client = clientRepository.findById(idClient);
		Manager manager = managerRepository.findById(idManager);
		newProjet.setClient(client);
		newProjet.setManager(manager);
		projetRepository.save(newProjet);
		return newProjet;
	}

	@Override
	public Projet getProjetById(int idProjet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projet updateProjet(Projet projet, int idProjet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Projet> getProjetsActifsByClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ActiverProjet(int idProjet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean DesactiverProjet(int idProjet) {
		// TODO Auto-generated method stub
		return null;
	}

}
