package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Competence;
import com.tn.saasProjectTicket.entity.CompetenceRessource;
import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.enums.NiveauMaitrise;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.CompetenceRepository;
import com.tn.saasProjectTicket.repository.CompetenceRessourceRepository;
import com.tn.saasProjectTicket.repository.RessourceRepository;
import com.tn.saasProjectTicket.repository.SocieteRepository;
import com.tn.saasProjectTicket.service.CompetenceRessourceService;

@Service
public class CompetenceRessourceServiceImpl implements CompetenceRessourceService {
	
	@Autowired
	private CompetenceRessourceRepository competenceRessourceRepository;
	@Autowired
	private RessourceRepository ressourceRepository;
	@Autowired
	private CompetenceRepository competenceRepository;
	@Autowired
	private SocieteRepository societeRepository;

	// 1. Ajouter une compétence pour une ressource
	@Override
	public CompetenceRessource ajouterCompetence(Integer ressourceId, Integer competenceId, NiveauMaitrise niveau) {
		if (competenceRessourceRepository.existsByRessourceUserIdAndCompetenceIdCompetence(ressourceId, competenceId)) {
	        throw new IllegalArgumentException("Cette compétence est déjà associée à la ressource.");
	    }
		
		Ressource ressource = ressourceRepository.findById(ressourceId)
	                .orElseThrow(() -> new RuntimeException("Ressource introuvable"));
	     Competence competence = competenceRepository.findById(competenceId)
	                .orElseThrow(() -> new RuntimeException("Compétence introuvable"));

	     CompetenceRessource competenceRessource = new CompetenceRessource();
	     competenceRessource.setRessource(ressource);
	     competenceRessource.setCompetence(competence);
	     competenceRessource.setNiveauMaitrise(niveau);
	     competenceRessource.setStatutValidation("En attente");
	     return competenceRessourceRepository.save(competenceRessource);
	}

	// 2.Valider ou refuser une competence
	@Override
	public CompetenceRessource validerCompetence(Integer competenceRessourceId, String statutValidation,
			String commentaire) {
		CompetenceRessource competenceRessource = competenceRessourceRepository.findById(competenceRessourceId)
                .orElseThrow(() -> new RuntimeException("CompétenceRessource introuvable"));

        competenceRessource.setStatutValidation(statutValidation);
        competenceRessource.setCommentaire(commentaire);
        return competenceRessourceRepository.save(competenceRessource);
	}

	// 3. Lister les compétences d'une ressource
	@Override
	public List<CompetenceRessource> listerCompetencesParRessource(Integer ressourceId) {
		return competenceRessourceRepository.findByRessourceUserId(ressourceId);
	}

	// 4. Lister toutes les compétences en attente de validation
	@Override
	public List<CompetenceRessource> listerCompetencesEnAttente() {
		return competenceRessourceRepository.findByStatutValidation("En attente");
	}

    // 5. Modifier la competenceRessource : statut devient 'en attente'
	@Override
	public CompetenceRessource updateCompetenceRessource(Integer idCR, String nouveauNiveau) {
		CompetenceRessource competenceRessource = competenceRessourceRepository.findById(idCR)
				.orElseThrow(() -> new RuntimeException("Competence introuvable!!"));
		
		competenceRessource.setNiveauMaitrise(NiveauMaitrise.valueOf(nouveauNiveau));
		competenceRessource.setStatutValidation("En attente");
		return competenceRessourceRepository.save(competenceRessource);
	}

	// 6. Supprimer une competenceRessource
	@Override
	public void supprimerCompetenceRessource(Integer idCR) {
		 competenceRessourceRepository.deleteById(idCR);
	}

	// 7. afficher les competenceRessource en Attente par societe
	@Override
	public List<CompetenceRessource> getCompetencesRessourceEnAttenteBySociete(Integer idSociete) {
		// Récupèrer tous les ressources de cette société
		List<Ressource> ressources = ressourceRepository.findBySociete_idSociete(idSociete);
		
		//on récupère les competenceRessource selon ces ressources:
		List<CompetenceRessource> competenceRessources = competenceRessourceRepository
				.findByRessourceInAndStatutValidation(ressources, "En attente");
		return competenceRessources;
	}

	// 8. update le statutValidation des competences
	@Override
	public CompetenceRessource updateStatutValidation(Integer idCR, String statutValidation) {
		CompetenceRessource competenceRessource = competenceRessourceRepository.findById(idCR)
				.orElseThrow(() -> new RuntimeException("Comeptence non trouvable avec cet id!"));
		competenceRessource.setStatutValidation(statutValidation);
		return competenceRessourceRepository.save(competenceRessource);
	}

}
