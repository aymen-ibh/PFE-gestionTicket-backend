package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
	
	@Query("SELECT p FROM Projet p WHERE " +
		       "(:clientId IS NULL OR p.client.id = :clientId) AND " +
		       "(:isActif IS NULL OR p.isActif = :isActif) AND " +
		       "(cast(:datedebutProjet as date) IS NULL OR p.datedebutProjet = :datedebutProjet) AND " +
		       "(cast(:dateFinProjet as date) IS NULL OR p.dateFinProjet = :dateFinProjet) AND " +
		       "(cast(:projetCreationDate as date) IS NULL OR p.projetCreationDate = :projetCreationDate) AND " +
		       "(:nomProjet IS NULL OR p.nomProjet = :nomProjet)")
		Set<Projet> findProjetsByCriteria(@Param("clientId") Integer clientId,
		                                  @Param("isActif") Boolean isActif,
		                                  @Param("datedebutProjet") Date datedebutProjet,
		                                  @Param("dateFinProjet") Date dateFinProjet,
		                                  @Param("projetCreationDate") Date projetCreationDate,
		                                  @Param("nomProjet") String nomProjet);
	
	/*@Query("SELECT p FROM Projet p WHERE p.client.id = :clientId AND p.isActif = :isActif")
	Set<Projet> findProjetsActifsParClientId(@Param("clientId") int clientId, @Param("isActif") boolean isActif);
	
	@Query("SELECT p FROM Projet p WHERE p.datedebutProjet = :datedebutProjet")
	Set<Projet> findProjetsByDateDebutProjet(@Param("datedebutProjet") Date datedebutProjet);
	
	@Query("SELECT p FROM Projet p WHERE p.dateFinProjet = :dateFinProjet")
	Set<Projet> findProjetsByDateFinProjet(@Param("dateFinProjet") Date dateFinProjet);
	
	@Query("SELECT p FROM Projet p WHERE p.projetCreationDate = :projetCreationDate")
	Set<Projet> findProjetsByProjetCreationDate(@Param("projetCreationDate") Date projetCreationDate);
	
	@Query("SELECT p FROM Projet p WHERE p.nomProjet = :nomProjet")
	Projet findProjetByNomProjet(@Param("nomProjet") String nomProjet);*/
	    
}
