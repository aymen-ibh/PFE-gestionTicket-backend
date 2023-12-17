package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Historique {
	
	@Id
	@GeneratedValue
	private Integer idHistorique;
	private Date dateHistorique;
}
