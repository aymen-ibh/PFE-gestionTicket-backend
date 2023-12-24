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
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Date creationDate;
	private Date updateDate;
	private String role;
	private boolean isActif;
	

	
	public Utilisateur() {
		super();
	}	

	public Utilisateur(Integer userId, String username, String password, String email, String firstName,
			String lastName, Date birthDate, Date creationDate, Date updateDate, String role, boolean isActif) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.role = role;
		this.isActif = isActif;
	}


	public boolean isActif() {
		return isActif;
	}


	public void setIsActif(boolean actif) {
		this.isActif = actif;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Utilisateur [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", creationDate="
				+ creationDate + ", updateDate=" + updateDate + ", role=" + role + "]";
	}
	
	

}
