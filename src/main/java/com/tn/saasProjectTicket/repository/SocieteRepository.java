package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Societe;

public interface SocieteRepository extends JpaRepository<Societe, Integer> {

	@Query("SELECT s FROM Societe s LEFT JOIN s.superviseur superviseur WHERE "+
	       "(:idSociete is null or s.id = :idSociete) AND " +
		   "(:nomSociete is null or s.nomSociete LIKE %:nomSociete%) AND " +
		   "(:adresse is null or s.adresse LIKE %:adresse%) AND " +
		   "(:secteurActivite is null or s.secteurActivite LIKE %:secteurActivite%) AND " +
		   "(cast(:societeCreationDate as date) is null or cast(s.societeCreationDate as date) = cast(:societeCreationDate as date)) AND " +
		   "(:usernameOwner is null or superviseur.username LIKE %:usernameOwner%)")
	  List<Societe> findByCriteria(@Param("idSociete") Integer idSociete,
			                       @Param("nomSociete") String nomSociete,
			                       @Param("adresse") String adresse,
			                       @Param("secteurActivite") String secteurActivite,
			                       @Param("societeCreationDate") Date societeCreationDate,
			                       @Param("usernameOwner") String usernameOwner);
}
