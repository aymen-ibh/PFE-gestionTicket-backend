package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.entity.RessourceCriteriaDTO;
import com.tn.saasProjectTicket.entity.RessourceDTO;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.RessourceRepository;
import com.tn.saasProjectTicket.service.RessourceService;

@Service
public class RessourceServiceImpl implements RessourceService {

	@Autowired
	private RessourceRepository ressourceRepository;
	
	@Override
	public List<RessourceDTO> getAllRessources() {
		List<Ressource> listRessource = this.ressourceRepository.findAll();
		return listRessource.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public RessourceDTO getRessource(int idRessource) {
		Ressource ressource = this.ressourceRepository.findById(idRessource).orElseThrow(
				() -> new RessourceNotFoundException("Ressource", "Id", idRessource));
		return convertToDto(ressource);
	}

	@Override
	public List<RessourceDTO> findRessourceByCriteria(RessourceCriteriaDTO criteria) {
		List<Ressource> filteredList = this.ressourceRepository.findByCriteria(
				criteria.getIdRessource(),
				criteria.getUsername(),
				criteria.getEmail(),
				criteria.getFirstName(),
				criteria.getLastName(),
				criteria.getBirthDate(),
				criteria.getIsActif(),
				criteria.getNomTicket());
		return filteredList.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	private RessourceDTO convertToDto(Ressource ressource) {
		RessourceDTO dto = new RessourceDTO();
		dto.setIdRessource(ressource.getUserId());
		dto.setFirstName(ressource.getFirstName());
		dto.setLastName(ressource.getLastName());
		dto.setEmail(ressource.getEmail());
		dto.setUsername(ressource.getUsername());
		dto.setBirthDate(ressource.getBirthDate());
		dto.setRole(ressource.getRole());
		dto.setActif(ressource.isActif());
		dto.setCreationDate(ressource.getCreationDate());
		dto.setUpdateDate(ressource.getUpdateDate());
		
		return dto;
	}

}
