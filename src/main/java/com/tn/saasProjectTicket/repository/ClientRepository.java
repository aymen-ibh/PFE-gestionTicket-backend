package com.tn.saasProjectTicket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.saasProjectTicket.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findById(int userId);
}
