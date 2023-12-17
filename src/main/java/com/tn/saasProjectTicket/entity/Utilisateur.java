package com.tn.saasProjectTicket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Utilisateur {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Date creationDate;
	private Date updateDate;
	private String role;

}
