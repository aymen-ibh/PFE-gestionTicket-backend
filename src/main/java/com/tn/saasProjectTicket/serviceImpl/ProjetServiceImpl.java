package com.tn.saasProjectTicket.serviceImpl;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Client;
import com.tn.saasProjectTicket.entity.Manager;
import com.tn.saasProjectTicket.entity.Projet;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
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
		Client client = clientRepository.findById(idClient).get();
		Manager manager = managerRepository.findById(idManager);
		newProjet.setClient(client);
		newProjet.setManager(manager);
		projetRepository.save(newProjet);
		return newProjet;
	}

	@Override
	public Projet getProjetById(int idProjet) {
		return projetRepository.findById(idProjet).orElseThrow(
				()->new RessourceNotFoundException("Projet","Id",idProjet)
				);
	}

	@Override
	public Projet updateProjet(Projet projet, int idProjet) {
		Projet projetExistant = projetRepository.findById(idProjet).get();
		projetExistant.setNomProjet(projet.getNomProjet());
		projetExistant.setDescriptionProjet(projet.getDescriptionProjet());
		projetExistant.setDatedebutProjet(projet.getDatedebutProjet());
		projetExistant.setDateFinProjet(projet.getDateFinProjet());
		
		int idClient = projet.getClient().getUserId();
		int idManager = projet.getManager().getUserId();
		Client client = clientRepository.findById(idClient).get();
		Manager manager = managerRepository.findById(idManager);
		projetExistant.setClient(client);
		projetExistant.setManager(manager);
		projetRepository.save(projetExistant);
		return projetExistant;
	}

	@Override
	public Set<Projet> getProjetsActifsParClient(int idClient) {
		return projetRepository.findProjetsActifsParClientId(idClient, true);
	}

	@Override
	public Projet activerProjet(int idProjet) {
		Projet projet = projetRepository.findById(idProjet).orElseThrow(
				()-> new RessourceNotFoundException("Projet", "Id", idProjet)
				);
		projet.setActif(true);
		projetRepository.save(projet) ;
		return projet;
	}

	@Override
	public Projet desactiverProjet(int idProjet) {
		Projet projet = projetRepository.findById(idProjet).orElseThrow(
				()-> new RessourceNotFoundException("Projet", "Id", idProjet)
				);
		projet.setActif(false);
		projetRepository.save(projet) ;
		return projet;
	}

	@Override
	public Set<Projet> getProjetsParDateDebutProjet(Date dateDebutProjet) {
		return projetRepository.findProjetsByDateDebutProjet(dateDebutProjet);
	}

	@Override
	public Set<Projet> getProjetsParDateFinProjet(Date dateFinProjet) {
		return projetRepository.findProjetsByDateFinProjet(dateFinProjet);
	}

	@Override
	public Set<Projet> getProjetsParProjetCreationDate(Date projetCreationDate) {
		return projetRepository.findProjetsByProjetCreationDate(projetCreationDate);
	}

	@Override
	public Projet getProjetParNomProjet(String nomProjet) {
		return projetRepository.findProjetByNomProjet(nomProjet);
	}

}
