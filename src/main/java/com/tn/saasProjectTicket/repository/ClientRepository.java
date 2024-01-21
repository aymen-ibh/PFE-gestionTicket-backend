package com.tn.saasProjectTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.saasProjectTicket.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
