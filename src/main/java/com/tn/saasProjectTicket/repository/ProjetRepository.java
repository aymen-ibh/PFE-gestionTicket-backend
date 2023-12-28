package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
	@Query("SELECT p FROM Projet p WHERE p.client.id = :clientId AND p.isActif = :isActif")
	Set<Projet> findProjetsActifsParClientId(@Param("clientId") int clientId, @Param("isActif") boolean isActif);
	
	@Query("SELECT p FROM Projet p WHERE p.datedebutProjet = :datedebutProjet")
	Set<Projet> findProjetsByDateDebutProjet(@Param("datedebutProjet") Date datedebutProjet);
	
	@Query("SELECT p FROM Projet p WHERE p.dateFinProjet = :dateFinProjet")
	Set<Projet> findProjetsByDateFinProjet(@Param("dateFinProjet") Date dateFinProjet);
	
	@Query("SELECT p FROM Projet p WHERE p.projetCreationDate = :projetCreationDate")
	Set<Projet> findProjetsByProjetCreationDate(@Param("projetCreationDate") Date projetCreationDate);
	
	@Query("SELECT p FROM Projet p WHERE p.nomProjet = :nomProjet")
	Projet findProjetByNomProjet(@Param("nomProjet") String nomProjet);
	    
}
