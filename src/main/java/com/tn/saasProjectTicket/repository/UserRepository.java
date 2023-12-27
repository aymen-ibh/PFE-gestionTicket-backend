package com.tn.saasProjectTicket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.saasProjectTicket.entity.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

	Optional <Utilisateur> findById(int userId);
	Optional<Utilisateur> findByUsername(String username);
	Optional<Utilisateur> findByEmail(String email);
}
