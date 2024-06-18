package com.tn.saasProjectTicket.serviceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Historique;
import com.tn.saasProjectTicket.entity.Projet;
import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.entity.RessourceDTO;
import com.tn.saasProjectTicket.entity.Ticket;
import com.tn.saasProjectTicket.entity.TicketCriteriaDTO;
import com.tn.saasProjectTicket.entity.TicketDTO;
import com.tn.saasProjectTicket.enums.Etat;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.HistoriqueRepository;
import com.tn.saasProjectTicket.repository.ProjetRepository;
import com.tn.saasProjectTicket.repository.RessourceRepository;
import com.tn.saasProjectTicket.repository.TicketRepository;
import com.tn.saasProjectTicket.service.MatchingService;
import com.tn.saasProjectTicket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	RessourceRepository ressourceRepository;
	
	@Autowired
	ProjetRepository projetRepository;
	
	@Autowired
	HistoriqueRepository historiqueRepository;
	
	@Autowired
	MatchingService matchingService;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public Ticket ajouterTicket(Integer idProjet, Ticket ticket) {
		return this.projetRepository.findById(idProjet).map(projet -> {
			ticket.setProjet(projet);
			ticket.setEtat(Etat.PENDING);
			addHistory(ticket, "Ticket créé","CREATION", null, ticket.toString());
			return this.ticketRepository.save(ticket);
		}).orElseThrow(() -> new RessourceNotFoundException("Ticket", "Id", ticket.getIdTicket()));
	}

	@Override
	public TicketDTO updateTicket(Ticket ticket, int idTicket) {
		Ticket ticketExistant = ticketRepository.findById(idTicket).get();
		String oldData = ticketExistant.toString();
		String ancienEtat = ticketExistant.getEtat().toString();
		
		ticketExistant.setNomTicket(ticket.getNomTicket());
		ticketExistant.setDescriptionTicket(ticket.getDescriptionTicket());
		ticketExistant.setEtat(ticket.getEtat());
		ticketExistant.setTicketUpdateDate(new Date());
		Ticket updatedTicket = ticketRepository.save(ticketExistant);
		
		String action = "Ticket mis à jour";
		if(!ticketExistant.getEtat().toString().equals(ancienEtat)) {
			
			switch (ticketExistant.getEtat().toString()) {
			case "TO_DO":
				action = "Ticket mis à l'état TO_DO";
				break;
			case "IN_PROGRESS":
				action = "Ticket mis à l'état IN_PROGRESS";
				break;
			case "DONE":
				action = "Ticket mis à jour à l'état DONE";
				break;

			default:
				action = "Ticket mis à jour";
				break;
			}
		}
		
		addHistory(ticketExistant, action, "MODIFICATION", oldData, convertToDTO(updatedTicket).toString());
		
		return convertToDTO(updatedTicket);
	}

	@Override
	public TicketDTO getTicket(int idTicket) {
		return convertToDTO(ticketRepository.findById(idTicket).orElseThrow(
				()->new RessourceNotFoundException("Ticket","Id",idTicket)
				));
	}

	@Override
	public List<TicketDTO> getTicketsByProjectAndEtat(Integer idProjet, Etat etat) {
		List<Ticket> ticketList = ticketRepository.findByProjetIdProjetAndEtat(idProjet, etat);
	    return ticketList.stream()
	    		.map(this::convertToDTO)
	    		.collect(Collectors.toList());
	}

	@Override
	public void deleteTicket(int idTicket) {
		Ticket ticket = ticketRepository.findById(idTicket).orElseThrow(
				()->new RessourceNotFoundException("Ticket","Id",idTicket)
				);
		addHistory(ticket, "Ticket supprimé", "SUPPRESSION", ticket.toString(), null);
		ticketRepository.delete(ticket);
		
	}
	
	@Override
	public TicketDTO assignRessourceToTicket(Integer idTicket, Integer idRessource) {
		Ticket ticket = this.ticketRepository.findById(idTicket)
				.orElseThrow(()-> new RessourceNotFoundException("Ticket","Id", idTicket));
		ticket.setEtat(Etat.AFFECTED);
		Ressource ressource = this.ressourceRepository.findById(idRessource)
				.orElseThrow(()-> new RessourceNotFoundException("Ressource", "Id", idRessource));
		ticket.setRessource(ressource);
		ticketRepository.save(ticket);
		return convertToDTO(ticket);
	}
	
	@Override
	public void unassignRessourceToTicket(Integer idTicket) {
		Ticket ticket = this.ticketRepository.findById(idTicket)
				.orElseThrow(()-> new RessourceNotFoundException("Ticket", "Id", idTicket));
		ticket.setRessource(null);
		ticketRepository.save(ticket);
	}

	private void addHistory(Ticket ticket, String action,String typeChangement, String oldValue, String newValue) {
		Historique history = new Historique();
		history.setTicket(ticket);
		history.setDateHistorique(LocalDateTime.now());
		history.setDescriptionAction(action);
		history.setAncienneValeur(oldValue);
		history.setNouvelleValeur(newValue);
		history.setTypeChangement(typeChangement);
		historiqueRepository.save(history);
	}

	@Override
	public Set<Ticket> findTicketsByCriteria(TicketCriteriaDTO criteria) {
		
		return ticketRepository.findByCriteria(
				criteria.getIdTicket(),
				criteria.getNomTicket(),
				criteria.getDescriptionTicket(),
				criteria.getEtat(),
				criteria.getStartDate(),
				criteria.getEndDate(),
				criteria.getCreePar()
				);
	}
	
	@Override
	public List<TicketDTO> getTicketsByRessourceAndEtat(Integer idRessource, Etat etat){
		List<Ticket> ticketList = ticketRepository.findByRessourceUserIdAndEtat(idRessource, etat);
		return ticketList.stream()
	    		.map(this::convertToDTO)
	    		.collect(Collectors.toList());
	}
	
	@Override
	public List<TicketDTO> getTicketsByManager(Integer idManager){
		List<Projet> projets = this.projetRepository.findByManager_userId(idManager);
		List<Ticket> tickets = this.ticketRepository.findByProjetIn(projets);
		return tickets.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
    }
	
	@Override
	public List<TicketDTO> getTicketsByClient(Integer idClient){
		List<Projet> projets = this.projetRepository.findByClient_userId(idClient);
		List<Ticket> tickets = this.ticketRepository.findByProjetIn(projets);
		return tickets.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<TicketDTO> getTicketsByProject(Integer idProjet){
		List<Ticket> tickets = ticketRepository.findByProjetIdProjet(idProjet);
		return tickets.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<RessourceDTO> suggestTopRessourcesForTicket(Integer ticketId){
		Ticket ticket = ticketRepository.findById(ticketId).get();
		Integer idSociete = ticket.getProjet().getClient().getSociete().getIdSociete();
		List<Ressource> societyRessources = ressourceRepository.findBySociete_idSociete(idSociete);
		List<Ressource> matchedResources = matchingService.topMatchingRessources(ticket, societyRessources, 3);
		return matchedResources.stream()
				.map(this::convertRToDTO)
				.collect(Collectors.toList());
	}
	
	private TicketDTO convertToDTO(Ticket ticket) {
		return this.mapper.map(ticket, TicketDTO.class);
	}
	private RessourceDTO convertRToDTO(Ressource ressource) {
		return this.mapper.map(ressource, RessourceDTO.class);
	}

}
