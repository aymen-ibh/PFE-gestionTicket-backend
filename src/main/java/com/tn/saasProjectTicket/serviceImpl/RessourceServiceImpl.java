package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.ProjetDTO;
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
	@Autowired
	ModelMapper mapper;
	
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
	
	@Override
	public List<RessourceDTO> getRessourceByTicket(Integer idTicket){
		List<Ressource> listRessources = this.ressourceRepository.findRessourcesByTicketId(idTicket);
		return listRessources.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<RessourceDTO> getRessourceNotAssignedToTicketBySociete(Integer idSociete, Integer idTicket){
		List<Ressource> listRessources = this.ressourceRepository.
				findRessourcesNotAssignedToTicketBySociete(idSociete, idTicket);
		return listRessources.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	private RessourceDTO convertToDto(Ressource ressource) {
		return mapper.map(ressource, RessourceDTO.class);
	}

}
