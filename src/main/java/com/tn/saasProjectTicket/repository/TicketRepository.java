package com.tn.saasProjectTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.saasProjectTicket.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
