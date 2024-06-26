package com.tn.saasProjectTicket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tn.saasProjectTicket.entity.Employe;
import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.repository.EmployeRepository;
import com.tn.saasProjectTicket.repository.ManagerRepository;
import com.tn.saasProjectTicket.repository.RessourceRepository;
import com.tn.saasProjectTicket.repository.UserRepository;
import com.tn.saasProjectTicket.service.EmployeService;

public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private RessourceRepository ressourceRepository;

	@Override
	public Utilisateur getEmploye(Integer userId) {
		Employe employe = this.employeRepository.findById(userId).get();
		if (employe.getRole().equals("MANAGER")) {
			return this.managerRepository.findById(userId).get();
			}
		else if (employe.getRole().equals("RESSOURCE")) {
			return this.ressourceRepository.findById(userId).get();
		}
		return employe;
	}

}
