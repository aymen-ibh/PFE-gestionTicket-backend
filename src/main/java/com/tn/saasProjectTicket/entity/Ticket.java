package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue
	private Integer idTicket;
	private String nomTicket;
	private String descriptionTicket;
	private Date ticketCreationDate;
	private Date ticketUpdateDate;

}
