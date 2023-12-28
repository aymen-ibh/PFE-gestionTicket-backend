package com.tn.saasProjectTicket.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
	@Query("SELECT p FROM Projet p WHERE p.client.id = :clientId AND p.isActif = :isActif")
	Set<Projet> findProjetsActifsParClientId(@Param("clientId") int clientId, @Param("isActif") boolean isActif);
	    
}
