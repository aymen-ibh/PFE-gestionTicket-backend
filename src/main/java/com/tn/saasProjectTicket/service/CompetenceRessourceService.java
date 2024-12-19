package com.tn.saasProjectTicket.service;

import java.util.List;

import com.tn.saasProjectTicket.entity.CompetenceRessource;
import com.tn.saasProjectTicket.enums.NiveauMaitrise;

public interface CompetenceRessourceService {
	// 1.Ajouter une competence à une ressource
	CompetenceRessource ajouterCompetence(Integer ressourceId, Integer competenceId, NiveauMaitrise niveau);
	
	// 2.Valider ou refuser une competence
	CompetenceRessource validerCompetence(Integer competenceRessourceId, String statutValidation, String commentaire);
	
	// 3. Lister les compétences d'une ressource
	List<CompetenceRessource> listerCompetencesParRessource(Integer ressourceId);
	
	// 4. Lister toutes les compétences en attente de validation
    List<CompetenceRessource> listerCompetencesEnAttente();
    
    // 5. Modifier la competenceRessource : statut devient 'en attente'
    CompetenceRessource updateCompetenceRessource(Integer idCR, String nouveauNiveau);
    
    // 6. Supprimer une competenceRessource
    void supprimerCompetenceRessource(Integer idCR);
    
    // 7. afficher les competenceRessource en Attente
    List<CompetenceRessource> getCompetencesRessourceEnAttenteBySociete(Integer idSociete);
    
    // 8. update le statutValidation des competences 
    CompetenceRessource updateStatutValidation(Integer idCR, String statutValidation);
	
}
