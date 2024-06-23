package com.tn.saasProjectTicket.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Client;
import com.tn.saasProjectTicket.entity.ClientDTO;
import com.tn.saasProjectTicket.entity.Employe;
import com.tn.saasProjectTicket.entity.Manager;
import com.tn.saasProjectTicket.entity.Projet;
import com.tn.saasProjectTicket.entity.ProjetCriteriaDTO;
import com.tn.saasProjectTicket.entity.ProjetDTO;
import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.entity.TicketDTO;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.ClientRepository;
import com.tn.saasProjectTicket.repository.EmployeRepository;
import com.tn.saasProjectTicket.repository.ManagerRepository;
import com.tn.saasProjectTicket.repository.ProjetRepository;
import com.tn.saasProjectTicket.repository.SuperviseurRepository;
import com.tn.saasProjectTicket.service.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {
	
	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ManagerRepository managerRepository;
	@Autowired
	SuperviseurRepository superviseurRepository;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ModelMapper mapper;

	@Override
	public List<ProjetDTO> getAllProjects() {
		List<Projet> listProjects = this.projetRepository.findAll();
		return listProjects.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public ProjetDTO ajouterProjet(Projet projet) {
		
		 return mapper.map(projetRepository.save(projet), ProjetDTO.class);
	}

	@Override
	public ProjetDTO getProjetById(int idProjet) {
		Projet projet = projetRepository.findById(idProjet).orElseThrow(
				()->new RessourceNotFoundException("Projet","Id",idProjet)
				);
		return convertToDto(projet);
	}

	@Override
	public Projet updateProjet(Projet projet, int idProjet) {
		Projet projetExistant = projetRepository.findById(idProjet).get();
		projetExistant.setNomProjet(projet.getNomProjet());
		projetExistant.setDescriptionProjet(projet.getDescriptionProjet());
		projetExistant.setDatedebutProjet(projet.getDatedebutProjet());
		projetExistant.setDateFinProjet(projet.getDateFinProjet());
		
		int idClient = projet.getClient().getUserId();
		int idManager = projet.getManager().getUserId();
		Client client = clientRepository.findById(idClient).get();
		Manager manager = managerRepository.findById(idManager).get();
		projetExistant.setClient(client);
		projetExistant.setManager(manager);
		projetRepository.save(projetExistant);
		return projetExistant;
	}

	@Override
	public List<ProjetDTO> findProjetsByCriteria(ProjetCriteriaDTO projetCriteriaDTO) {
		 List<Projet> listProjets = projetRepository.findByCriteria(
                projetCriteriaDTO.getIdClient(),
                projetCriteriaDTO.getIdManager(),
                projetCriteriaDTO.getIsActif(),
                projetCriteriaDTO.getDatedebutProjet(),
                projetCriteriaDTO.getDateFinProjet(),
                projetCriteriaDTO.getProjetCreationDate(),
                projetCriteriaDTO.getNomProjet());
		 return listProjets.stream()
				 .map(this::convertToDto)
				 .collect(Collectors.toList());
	}

	@Override
	public Projet activerProjet(int idProjet) {
		Projet projet = projetRepository.findById(idProjet).orElseThrow(
				()-> new RessourceNotFoundException("Projet", "Id", idProjet)
				);
		projet.setActif(true);
		projetRepository.save(projet) ;
		return projet;
	}
	
	@Override
	public Projet desactiverProjet(int idProjet) {
		Projet projet = projetRepository.findById(idProjet).orElseThrow(
				()-> new RessourceNotFoundException("Projet", "Id", idProjet)
				);
		projet.setActif(false);
		projetRepository.save(projet) ;
		return projet;
	}
	
	@Override
	public List<ProjetDTO> getSocieteProjets(int idSociete) {
		
		List<Projet> listProjets = new ArrayList<Projet>();
		listProjets = this.projetRepository.findProjetsBySocieteId(idSociete);
		return listProjets.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProjetDTO> getProjectsByClient(int idClient){
		List<Projet> listProjets = new ArrayList<Projet>();
		listProjets = this.projetRepository.findByClient_userId(idClient);
		return listProjets.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProjetDTO> getProjectsByManager(int idManager){
		List<Projet> listProjects = new ArrayList<Projet>();
		listProjects = this.projetRepository.findByManager_userId(idManager);
		return listProjects.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	private ProjetDTO convertToDto(Projet projet) {
		ProjetDTO projetDTO = mapper.map(projet, ProjetDTO.class);
		//projetDTO.setTickets(convertTickets(projet.getTickets()));
		return projetDTO;
	}
	
	/*private List<TicketDTO> convertTickets(List<Ticket> tickets) {
        if (tickets == null) {
            return new ArrayList<>();
        }
        return tickets.stream()
                .map(ticket -> {
                    TicketDTO ticketDTO = mapper.map(ticket, TicketDTO.class);
                    ticketDTO.setProjet(null); // Eviter les références circulaires
                    return ticketDTO;
                })
                .collect(Collectors.toList());
    }*/

}
