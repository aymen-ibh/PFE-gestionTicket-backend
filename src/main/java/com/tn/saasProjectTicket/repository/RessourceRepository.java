package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Ressource;

public interface RessourceRepository extends JpaRepository<Ressource, Integer> {

	@Query("SELECT DISTINCT r FROM Ressource r LEFT JOIN r.tickets tickets WHERE " +
		       "(:idRessource is null or r.id = :idRessource) AND " +
		       "(:username is null or r.username LIKE %:username%) AND " +
		       "(:email is null or r.email LIKE %:email%) AND " +
		       "(:firstName is null or r.firstName LIKE %:firstName%) AND " +
		       "(:lastName is null or r.lastName LIKE %:lastName%) AND " +
		       "(cast(:birthDate as date) is null or r.birthDate = :birthDate) AND " +
		       "(:isActif is null or r.isActif = :isActif) AND " +
		       "(:nomTicket is null or tickets.nomTicket LIKE %:nomTicket%)")
		List<Ressource> findByCriteria(@Param("idRessource") Integer idRessource,
		                            @Param("username") String username,
		                            @Param("email") String email,
		                            @Param("firstName") String firstName,
		                            @Param("lastName") String lastName,
		                            @Param("birthDate") Date birthDate,
		                            @Param("isActif") Boolean isActif,
		                            @Param("nomTicket") String nomTicket);
	@Query("SELECT r FROM Ressource r JOIN r.tickets t WHERE t.id = :idTicket")
	List<Ressource> findRessourcesByTicketId(@Param("idTicket") Integer idTicket);
	
	@Query("SELECT r FROM Ressource r WHERE r.societe.id = :idSociete AND " +
	           "NOT EXISTS (SELECT 1 FROM Ticket t WHERE t.id = :idTicket AND t.ressource.id = r.id)")
	List<Ressource> findRessourcesNotAssignedToTicketBySociete(@Param("idSociete") Integer idSociete,
			                                                   @Param("idTicket") Integer idTicket);
	
	List<Ressource> findBySociete_idSociete(Integer idSociete);
	List<Ressource> findByDisponibleTrue();
}
