package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Competence;
import com.tn.saasProjectTicket.repository.CompetenceRepository;
import com.tn.saasProjectTicket.service.CompetenceService;

@Service
public class CompetenceServiceImpl implements CompetenceService {
	
	@Autowired
	private CompetenceRepository competenceRepository;

	@Override
	// Rechercher des compétences contenant un terme donné
	public List<Competence> searchCompetences(String term) {
		return competenceRepository.findByNomContainingIgnoreCase(term);
	}
	
	@Override
	public Competence createCompetence(Competence competence) {
		Optional<Competence> existingCompetence = competenceRepository.findByNomIgnoreCase(competence.getNom());
		if (existingCompetence.isPresent()) {
			//renvoyer la compétence si elle existe
			return existingCompetence.get();
		}
		//ajouter la competence si elle n'existe pas(au table competence et non pas competenceRessource)
		return competenceRepository.save(competence);
	}

	

}
