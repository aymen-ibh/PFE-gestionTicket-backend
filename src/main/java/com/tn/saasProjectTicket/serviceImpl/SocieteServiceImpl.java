package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Societe;
import com.tn.saasProjectTicket.entity.SocieteCriteriaDTO;
import com.tn.saasProjectTicket.entity.SocieteDTO;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.SocieteRepository;
import com.tn.saasProjectTicket.service.SocieteService;

@Service
public class SocieteServiceImpl implements SocieteService {
	
	@Autowired
	private SocieteRepository societeRepository;

	@Override
	public List<SocieteDTO> getAllSocities() {
		List<Societe> listSocities = this.societeRepository.findAll();
		
		return listSocities.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public SocieteDTO getSociete(int idSociete) {
		Societe societe = this.societeRepository.findById(idSociete).orElseThrow(
				() -> new RessourceNotFoundException("Societe", "Id", idSociete)
				);
		return convertToDto(societe);
	}
	
	@Override
	public List<SocieteDTO> findSocietyByCriteria(SocieteCriteriaDTO societeCriteria) {
		List<Societe> listSociete = this.societeRepository.findByCriteria(
				societeCriteria.getIdSociete(),
				societeCriteria.getNomSociete(), 
				societeCriteria.getAdresse(), 
			    societeCriteria.getSecteurActivite(), 
				societeCriteria.getSocieteCreationDate(), 
				societeCriteria.getUsernameOwner());
		return listSociete.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	private SocieteDTO convertToDto(Societe societe) {
		SocieteDTO dto = new SocieteDTO();
		dto.setIdSociete(societe.getIdSociete());
		dto.setNomSociete(societe.getNomSociete());
		dto.setSecteurActivite(societe.getSecteurActivite());
		dto.setAdresse(societe.getAdresse());
		dto.setSocieteCreationDate(societe.getSocieteCreationDate());
		dto.setSocieteUpdateDate(societe.getSocieteUpdateDate());
		
		dto.setFirstNameOwner(societe.getSuperviseur().getFirstName());
		dto.setLastNameOwner(societe.getSuperviseur().getLastName());
		dto.setUsernameOwner(societe.getSuperviseur().getUsername());
		
		return dto;
	}

	

}
