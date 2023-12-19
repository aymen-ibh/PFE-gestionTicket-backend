package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Admin extends Utilisateur{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer userId, String username, String password, String email, String firstName, String lastName,
			Date birthDate, Date creationDate, Date updateDate, String role) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role);
		// TODO Auto-generated constructor stub
	}

}
