package com.tn.saasProjectTicket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.saasProjectTicket.entity.Employe;
import com.tn.saasProjectTicket.entity.Manager;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	
	Employe findByUserIdAndSocieteIdSociete(int idManager, int idSociete);
	
	List<Manager> findBySocieteIdSociete(int idSociete);
}
