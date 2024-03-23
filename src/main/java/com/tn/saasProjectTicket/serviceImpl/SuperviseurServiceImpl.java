package com.tn.saasProjectTicket.serviceImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.saasProjectTicket.entity.Societe;
import com.tn.saasProjectTicket.entity.Superviseur;
import com.tn.saasProjectTicket.entity.SuperviseurCriteriaDTO;
import com.tn.saasProjectTicket.entity.SuperviseurRegistrationDto;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;
import com.tn.saasProjectTicket.repository.SocieteRepository;
import com.tn.saasProjectTicket.repository.SuperviseurRepository;
import com.tn.saasProjectTicket.repository.UserRepository;
import com.tn.saasProjectTicket.service.SuperviseurService;

@Service
public class SuperviseurServiceImpl implements SuperviseurService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SuperviseurRepository superviseurRepository;
	
	@Autowired
	private SocieteRepository societeRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private MailTicketServiceImpl mailTicketServiceImpl;

	@Override
	@Transactional
	public Superviseur registerSuperviseurEtSociete(SuperviseurRegistrationDto registrationDto) {
		if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("Nom d'utilisateur déjà pris");
        }
        if (userRepository.findByEmail(registrationDto.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("Email déjà utilisé");
        }
        Superviseur superviseur = new Superviseur();
        superviseur.setEmail(registrationDto.getEmail());
		superviseur.setUsername(registrationDto.getUsername());
		superviseur.setPassword(encoder.encode(registrationDto.getPassword()));
		superviseur.setRole(registrationDto.getRole());
		superviseur.setBirthDate(registrationDto.getBirthDate());
		superviseur.setFirstName(registrationDto.getFirstName());
		superviseur.setLastName(registrationDto.getLastName());
		superviseur.setCreationDate(new Date());
		superviseur.setUpdateDate(new Date());
		superviseur.setActif(true);
		
		Societe societe = new Societe();
		societe.setNomSociete(registrationDto.getNomSociete());
		societe.setAdresse(registrationDto.getAdresse());
		societe.setSecteurActivite(registrationDto.getSecteurActivite());
		societe.setSocieteCreationDate(new Date());
		societe.setSocieteUpdateDate(new Date());
		
		superviseur.setSociete(societe);
		societe.setSuperviseur(superviseur);
		
		mailTicketServiceImpl.sendMAil(
				registrationDto.getEmail(), "Creation account", "title for test", "message for test");
		superviseurRepository.save(superviseur);
		societeRepository.save(societe);
        
		return superviseur;
	}

	@Override
	public List<SuperviseurRegistrationDto> getAllSuperviseur() {
		List<Superviseur> listSuperviseur = superviseurRepository.findAll();

		return listSuperviseur.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public SuperviseurRegistrationDto getSuperviseur(int idSuperviseur) {
		Superviseur superviseur = superviseurRepository.findById(idSuperviseur).orElseThrow(
				()-> new RessourceNotFoundException("Superviseur","Id",idSuperviseur)
				);
		return convertToDto(superviseur);
	}

	@Override
	public void deleteSuperviseur(int idSuperviseur) {
		Superviseur superviseur = superviseurRepository.findById(idSuperviseur).orElseThrow(
				()-> new RessourceNotFoundException("Superviseur", "Id", idSuperviseur)
				);
		superviseurRepository.delete(superviseur);
		
	}

	@Override
	public SuperviseurRegistrationDto updateSuperviseur(SuperviseurRegistrationDto registrationDto, int idSuperviseur) {
		Superviseur superviseur = superviseurRepository.findById(idSuperviseur).orElseThrow(
				()-> new RessourceNotFoundException("Superviseur", "Id", idSuperviseur)
				);
		superviseur.setEmail(registrationDto.getEmail());
		superviseur.setUsername(registrationDto.getUsername());
		superviseur.setPassword(encoder.encode(registrationDto.getPassword()));
		superviseur.setBirthDate(registrationDto.getBirthDate());
		superviseur.setFirstName(registrationDto.getFirstName());
		superviseur.setLastName(registrationDto.getLastName());
		
		Societe societe = societeRepository.findById(superviseur.getSociete().getIdSociete()).orElseThrow(
				()-> new RessourceNotFoundException("Societe", "Id", superviseur.getSociete().getIdSociete())
				);
		societe.setNomSociete(registrationDto.getNomSociete());
		societe.setAdresse(registrationDto.getAdresse());
		societe.setSecteurActivite(registrationDto.getSecteurActivite());
		
		superviseurRepository.save(superviseur);
		societeRepository.save(societe);
		return convertToDto(superviseur);
	}
	
	@Override
	public List<SuperviseurRegistrationDto> findSuperviseurByCriteria(SuperviseurCriteriaDTO superviseurDto) {
		 List<Superviseur> listSuperviseur =  superviseurRepository.findByCriteria(
				superviseurDto.getId(),
				superviseurDto.getUsername(),
				superviseurDto.getEmail(),
				superviseurDto.getFirstName(),
				superviseurDto.getLastName(),
				superviseurDto.getBirthDate(),
				superviseurDto.getIsActif(),
				superviseurDto.getNomSociete()
				);
		 return listSuperviseur.stream()
					.map(this::convertToDto)
					.collect(Collectors.toList());
	}
	
	private SuperviseurRegistrationDto convertToDto(Superviseur superviseur) {
		SuperviseurRegistrationDto dto = new SuperviseurRegistrationDto();
		dto.setIdSuperviseur(superviseur.getUserId());
		dto.setUsername(superviseur.getUsername());
		dto.setEmail(superviseur.getEmail());
		dto.setPassword(superviseur.getPassword());
		dto.setFirstName(superviseur.getFirstName());
		dto.setLastName(superviseur.getLastName());
		dto.setBirthDate(superviseur.getBirthDate());
		dto.setCreationDate(superviseur.getCreationDate());
		dto.setUpdateDate(superviseur.getUpdateDate());
		dto.setRole(superviseur.getRole());
		dto.setActif(superviseur.isActif());
		dto.setPhoto(superviseur.getPhoto());
		
		dto.setNomSociete(superviseur.getSociete().getNomSociete());
		dto.setAdresse(superviseur.getSociete().getAdresse());
		dto.setSecteurActivite(superviseur.getSociete().getSecteurActivite());
		dto.setSocieteCreationDate(superviseur.getSociete().getSocieteCreationDate());
		dto.setSocieteUpdateDate(superviseur.getSociete().getSocieteUpdateDate());
		
		return dto;
		
	}


	@Override
	public SuperviseurRegistrationDto changerEtatSuperviseur(int idSuperviseur, boolean etatActif) {
		Superviseur superviseur = superviseurRepository.findById(idSuperviseur).orElseThrow(
				() -> new RessourceNotFoundException("Superviseur", "Id", idSuperviseur)
				);
		superviseur.setActif(etatActif);
		superviseurRepository.save(superviseur);
		return convertToDto(superviseur);
	}


}
