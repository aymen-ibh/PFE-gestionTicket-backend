package com.tn.saasProjectTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.saasProjectTicket.entity.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

}
