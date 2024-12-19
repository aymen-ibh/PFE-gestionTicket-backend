package com.tn.saasProjectTicket.service;

import java.util.List;

import com.tn.saasProjectTicket.entity.Competence;

public interface CompetenceService {
	
    List<Competence> searchCompetences(String term);
	Competence createCompetence(Competence competence);
}
