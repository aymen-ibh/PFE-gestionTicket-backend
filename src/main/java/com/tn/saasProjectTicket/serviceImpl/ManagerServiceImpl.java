package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Manager;
import com.tn.saasProjectTicket.entity.ManagerCriteriaDTO;
import com.tn.saasProjectTicket.entity.ManagerDTO;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.EmployeRepository;
import com.tn.saasProjectTicket.repository.ManagerRepository;
import com.tn.saasProjectTicket.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<ManagerDTO> getAllManagers() {
		List<Manager> listManager = this.managerRepository.findAll();
		return listManager.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public ManagerDTO getManager(int idManager) {
		Manager manager = this.managerRepository.findById(idManager).orElseThrow(
				() -> new RessourceNotFoundException("Manager", "Id", idManager)
				);
		return convertToDto(manager);
	}

	@Override
	public List<ManagerDTO> findManagerByCriteria(ManagerCriteriaDTO criteria) {
		List<Manager> listFiltered = this.managerRepository.findByCriteria(
				criteria.getIdManager(),
				criteria.getUsername(),
				criteria.getEmail(),
				criteria.getFirstName(),
				criteria.getLastName(),
				criteria.getBirthDate(),
				criteria.getIsActif(),
				criteria.getNomProjet());
		return listFiltered.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ManagerDTO> getManagersBySociete(int idSociete){
		List<Manager> listManagers = this.employeRepository.findBySocieteIdSociete(idSociete);
		return listManagers.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	private ManagerDTO convertToDto(Manager manager) {
		return mapper.map(manager, ManagerDTO.class);

	}

}
