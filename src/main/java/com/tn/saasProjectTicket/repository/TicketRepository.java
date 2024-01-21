package com.tn.saasProjectTicket.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.enums.Etat;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query("SELECT t FROM Ticket t WHERE " +
	           "(:idTicket IS NULL OR t.idTicket = :idTicket) AND " +
	           "(:nomTicket IS NULL OR t.nomTicket LIKE %:nomTicket%) AND " +
	           "(:descriptionTicket IS NULL OR t.descriptionTicket LIKE %:descriptionTicket%) AND " +
	           "(:etat IS NULL OR t.etat = :etat) AND " +
	           "(cast(:startDate as date) IS NULL OR t.ticketCreationDate >= :startDate) AND " +
	           "(cast(:endDate as date) IS NULL OR t.ticketCreationDate <= :endDate) AND " +
	           "(:creePar IS NULL or t.ressource.id = :creePar)")
	    Set<Ticket> findByCriteria(
	            @Param("idTicket") Integer idTicket,
	            @Param("nomTicket") String nomTicket,
	            @Param("descriptionTicket") String descriptionTicket,
	            @Param("etat") Etat etat,
	            @Param("startDate") Date startDate,
	            @Param("endDate") Date endDate,
	            @Param("creePar") Integer creePar);
}
