package com.tn.saasProjectTicket.service;

import java.util.List;

import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.entity.Ticket;

public interface MatchingService {
	
	List<Ressource> topMatchingRessources(Ticket ticket, List<Ressource> ressources, int topN);
	int calculateMatchingScore(Ticket ticket, Ressource ressource);
}
