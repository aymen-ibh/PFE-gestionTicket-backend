package com.tn.saasProjectTicket.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.saasProjectTicket.entity.Societe;
import com.tn.saasProjectTicket.entity.Superviseur;
import com.tn.saasProjectTicket.entity.SuperviseurRegistrationDto;
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
		superviseur.setIsActif(true);
		
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

}
