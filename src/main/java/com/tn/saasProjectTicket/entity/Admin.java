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
			Date birthDate, Date creationDate, Date updateDate, String role, boolean isActif, String photo) {
		super(userId, username, password, email, firstName, lastName, birthDate, creationDate, updateDate, role, isActif,
				photo);
		// TODO Auto-generated constructor stub
	}
	

}
