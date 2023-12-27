package com.tn.saasProjectTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.saasProjectTicket.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
	Manager findById(int idUser);
}
