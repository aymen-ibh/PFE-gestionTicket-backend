package com.tn.saasProjectTicket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Superviseur extends Utilisateur {
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "societe_id", referencedColumnName = "idSociete")
	private Societe societe;

	public Superviseur() {
		super();
	}

	public Superviseur(Societe societe) {
		super();
		this.societe = societe;
	}

	public Superviseur(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role,boolean isActif) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role,isActif);
		// TODO Auto-generated constructor stub
	}
	

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	@Override
	public String toString() {
		return "Superviseur [societe=" + societe + "]";
	}

	
	
}
