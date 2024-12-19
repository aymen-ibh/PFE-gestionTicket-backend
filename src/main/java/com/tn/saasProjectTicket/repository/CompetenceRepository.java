package com.tn.saasProjectTicket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tn.saasProjectTicket.entity.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Integer> {

	// Rechercher des compétences dont le nom contient un certain terme
    List<Competence> findByNomContainingIgnoreCase(String term);

    // Vérifier si une compétence existe par son nom (insensible à la casse)
    Optional<Competence> findByNomIgnoreCase(String nom);
}
