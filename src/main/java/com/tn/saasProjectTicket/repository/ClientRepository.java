package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	@Query("SELECT DISTINCT c FROM Client c LEFT JOIN c.projets projets WHERE " +
		       "(:idClient is null or c.id = :idClient) AND " +
		       "(:username is null or c.username LIKE %:username%) AND " +
		       "(:email is null or c.email LIKE %:email%) AND " +
		       "(:firstName is null or c.firstName LIKE %:firstName%) AND " +
		       "(:lastName is null or c.lastName LIKE %:lastName%) AND " +
		       "(cast(:birthDate as date) is null or c.birthDate = :birthDate) AND " +
		       "(:isActif is null or c.isActif = :isActif) AND " +
		       "(:nomProjet is null or projets.nomProjet LIKE %:nomProjet%)")
		List<Client> findByCriteria(@Param("idClient") Integer idClient,
		                            @Param("username") String username,
		                            @Param("email") String email,
		                            @Param("firstName") String firstName,
		                            @Param("lastName") String lastName,
		                            @Param("birthDate") Date birthDate,
		                            @Param("isActif") Boolean isActif,
		                            @Param("nomProjet") String nomProjet);
	Client findByUserIdAndSocieteIdSociete(int idClient, int idSociete);
	
	List<Client> findBySocieteIdSociete(int idSociete);
}
