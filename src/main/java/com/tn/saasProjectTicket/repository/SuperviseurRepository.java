package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Superviseur;

public interface SuperviseurRepository extends JpaRepository<Superviseur, Integer> {

	@Query("SELECT s FROM Superviseur s LEFT JOIN s.societe societe WHERE " +
	           "(:idSuperviseur is null or s.id = :idSuperviseur) AND " +
	           "(:username is null or s.username LIKE %:username%) AND " +
	           "(:email is null or s.email LIKE %:email%) AND " +
	           "(:firstName is null or s.firstName LIKE %:firstName%) AND " +
	           "(:lastName is null or s.lastName LIKE %:lastName%) AND " +
	           "(cast(:birthDate as date) is null or cast(s.birthDate as date) = cast(:birthDate as date)) AND " +
	           "(:isActif is null or s.isActif = :isActif) AND " +
	           "(:nomSociete is null or societe.nomSociete LIKE %:nomSociete%)")
	    List<Superviseur> findByCriteria(@Param("idSuperviseur") Integer idSuperviseur,
	                                     @Param("username") String username,
	                                     @Param("email") String email,
	                                     @Param("firstName") String firstName,
	                                     @Param("lastName") String lastName,
	                                     @Param("birthDate") Date birthDate,
	                                     @Param("isActif") Boolean isActif,
	                                     @Param("nomSociete") String nomSociete);
	Superviseur findByUsername(String username);
	
}
