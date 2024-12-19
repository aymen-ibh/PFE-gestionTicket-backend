package com.tn.saasProjectTicket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.CompetenceRessource;
import com.tn.saasProjectTicket.entity.Ressource;

public interface CompetenceRessourceRepository extends JpaRepository<CompetenceRessource, Integer> {
	List<CompetenceRessource> findByStatutValidation(String statutValidation);
    List<CompetenceRessource> findByRessourceUserId(Integer ressourceId);
    boolean existsByRessourceUserIdAndCompetenceIdCompetence(Integer ressourceId, Integer competenceId);
    
    /**
     * Récupère les competencesRessource pour une liste de ressources et un statut donné.
     * @param ressources La liste des ressources
     * @param statutValidation Le statut des competencesRessource
     * @return Liste des CompetenceRessource correspondantes
     */
    List<CompetenceRessource> findByRessourceInAndStatutValidation(List<Ressource> ressources, String statutValidation);
}
