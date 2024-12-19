package com.tn.saasProjectTicket.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.CompetenceRessource;
import com.tn.saasProjectTicket.entity.CompetenceTicket;
import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.entity.RessourceScore;
import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.enums.NiveauMaitrise;
import com.tn.saasProjectTicket.repository.RessourceRepository;
import com.tn.saasProjectTicket.repository.TicketRepository;
import com.tn.saasProjectTicket.service.MatchingService;
@Service
public class MatchingServiceImpl implements MatchingService {
	
	@Autowired
	private RessourceRepository ressourceRepository;
	@Autowired
	private TicketRepository ticketRepository;

	// Méthode pour trouver les N meilleures ressources correspondant à un ticket donné
	@Override
	public List<Ressource> topMatchingRessources(Ticket ticket, List<Ressource> ressources, int topN) {
		
		List<RessourceScore> ressourceScores = new ArrayList<RessourceScore>();
		
		for (Ressource ressource: ressources) {
			if (ressource.isDisponible()) {
				int score = calculateMatchingScore(ticket, ressource);
				ressourceScores.add(new RessourceScore(ressource, score));
			}
		}
		
		// On va trier les ressources par ordre decroissant
		ressourceScores.sort((rs1,rs2) -> Integer.compare(rs2.getScore(), rs1.getScore()));
		
		//déduire les topN(nbre de ressources à afficher) Resources
		return ressourceScores.stream()
				.limit(topN)
				.map(RessourceScore::getRessource)
				.collect(Collectors.toList());
	}

	// calculer le score de correspondance entre un ticket et une ressource
	@Override
	public int calculateMatchingScore(Ticket ticket, Ressource ressource) {
		int score = 0;
		
		for (CompetenceTicket competenceTicket : ticket.getCompetencesRequises()) {
			for (CompetenceRessource competenceRessource : ressource.getCompetencesAquis()) {
				if (competenceTicket.getCompetence().equals(competenceRessource.getCompetence())) {
					score += matchLevelScore(competenceTicket.getNiveauMaitrise().toString(),
							                 competenceRessource.getNiveauMaitrise().toString());
				}
			}
		}
		return score;
	}

	// Méthode pour comparer les niveaux de maîtrise en utilisant des chaînes de caractères
	private int matchLevelScore(String required, String aquired) {
		NiveauMaitrise requiredLevel = NiveauMaitrise.valueOf(required.toUpperCase());
		NiveauMaitrise aquiredLevel = NiveauMaitrise.valueOf(aquired.toUpperCase());
		
		if (aquiredLevel == requiredLevel) {
			return 3; // Correspondance exacte
		} else if (aquiredLevel.ordinal() > requiredLevel.ordinal()) {
			return 2; // surqualifié
		} else {
			return 1; // sous-qualifié
		}
	}

	
}
