package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Projet {
	
	@Id
	@GeneratedValue
	private Integer idProjet;
	private String nomProjet;
	private String descriptionProjet;
	private Date datedebutProjet;
	private Date dateFinProjet;
	private Date projetCreationDate;
	private Date projetUpdateDate;
	
	
	public Projet() {
		super();
	}
	
	

}
