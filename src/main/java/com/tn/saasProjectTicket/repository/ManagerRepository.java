package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
	

	@Query("SELECT DISTINCT m FROM Manager m LEFT JOIN m.projets projets WHERE " +
		       "(:idManager is null or m.id = :idManager) AND " +
		       "(:username is null or m.username LIKE %:username%) AND " +
		       "(:email is null or m.email LIKE %:email%) AND " +
		       "(:firstName is null or m.firstName LIKE %:firstName%) AND " +
		       "(:lastName is null or m.lastName LIKE %:lastName%) AND " +
		       "(cast(:birthDate as date) is null or m.birthDate = :birthDate) AND " +
		       "(:isActif is null or m.isActif = :isActif) AND " +
		       "(:nomProjet is null or projets.nomProjet LIKE %:nomProjet%)")
		List<Manager> findByCriteria(@Param("idManager") Integer idManager,
		                            @Param("username") String username,
		                            @Param("email") String email,
		                            @Param("firstName") String firstName,
		                            @Param("lastName") String lastName,
		                            @Param("birthDate") Date birthDate,
		                            @Param("isActif") Boolean isActif,
		                            @Param("nomProjet") String nomProjet);
}
