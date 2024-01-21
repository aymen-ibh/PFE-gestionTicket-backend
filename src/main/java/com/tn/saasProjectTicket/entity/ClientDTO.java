package com.tn.saasProjectTicket.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClientDTO {
	private int idClient;
	private String username;//
	private String email;//
	private String firstName;//
	private String lastName;//
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate;
	private Date creationDate;
	private Date updateDate;
	private String role;
	private boolean isActif;
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public boolean isActif() {
		return isActif;
	}
	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}
	public ClientDTO() {
		super();
	}
	public ClientDTO(int idClient, String username, String email, String firstName, String lastName, Date birthDate,
			Date creationDate, Date updateDate, String role, boolean isActif) {
		super();
		this.idClient = idClient;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.role = role;
		this.isActif = isActif;
	}
	
}
