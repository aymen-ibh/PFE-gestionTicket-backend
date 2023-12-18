package com.tn.saasProjectTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.saasProjectTicket.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {

}
