package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employe extends Utilisateur {
	
	@ManyToOne
	private Societe societe;
	
	
	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public Employe(Societe societe) {
		super();
		this.societe = societe;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role, boolean isActif, String photo, Societe societe) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role, isActif,
				photo);
		// TODO Auto-generated constructor stub
		this.societe=societe;
	}

	
	


	
}
