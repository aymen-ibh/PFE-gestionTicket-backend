package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
	
	    @Query("SELECT p FROM Projet p " +
			   "LEFT JOIN p.client client " +
	           "LEFT JOIN p.manager manager WHERE " +
		       "(:idClient IS NULL OR client.id = :idClient) AND " +
		       "(:idManager IS NULL OR manager.id = :idManager) AND " +
		       "(:isActif IS NULL OR p.isActif = :isActif) AND " +
		       "(cast(:datedebutProjet as date) IS NULL OR p.datedebutProjet = :datedebutProjet) AND " +
		       "(cast(:dateFinProjet as date) IS NULL OR p.dateFinProjet = :dateFinProjet) AND " +
		       "(cast(:projetCreationDate as date) IS NULL OR p.projetCreationDate = :projetCreationDate) AND " +
		       "(:nomProjet IS NULL OR p.nomProjet LIKE %:nomProjet%)")
		List<Projet> findByCriteria(@Param("idClient") Integer idClient,
				                          @Param("idManager") Integer idManager,
		                                  @Param("isActif") Boolean isActif,
		                                  @Param("datedebutProjet") Date datedebutProjet,
		                                  @Param("dateFinProjet") Date dateFinProjet,
		                                  @Param("projetCreationDate") Date projetCreationDate,
		                                  @Param("nomProjet") String nomProjet);
	
	
	public List<Projet> findByClient_userId(Integer clientId);
	
	public List<Projet> findByClient_userIdIn(List<Integer>  clientId);
	
	@Query("SELECT p FROM Projet p JOIN p.client c WHERE c.societe.id = :idSociete")
	public List<Projet> findProjetsBySocieteId(@PathParam("idSociete") Integer idSociete);
	
	public List<Projet> findByManager_userId(Integer managerId);
	
	Integer countByManager_userId(Integer managerId);
	Integer countByClient_userId(Integer clientId);

	    
}
