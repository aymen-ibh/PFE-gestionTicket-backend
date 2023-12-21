package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employe extends Utilisateur {

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role);
		// TODO Auto-generated constructor stub
	}
	
	
}
