package com.tn.saasProjectTicket.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RessourceCriteriaDTO {
	private Integer idRessource;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    private Boolean isActif;
    private String nomTicket;
    
	
	public Integer getIdRessource() {
		return idRessource;
	}
	public void setIdRessource(Integer idRessource) {
		this.idRessource = idRessource;
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
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public String getNomTicket() {
		return nomTicket;
	}
	public void setNomTicket(String nomTicket) {
		this.nomTicket = nomTicket;
	}
	public RessourceCriteriaDTO() {
		super();
	}
	public RessourceCriteriaDTO(Integer idRessource, String username, String email, String firstName, String lastName,
			Date birthDate, Boolean isActif, String nomTicket) {
		super();
		this.idRessource = idRessource;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.isActif = isActif;
		this.nomTicket = nomTicket;
	}
    
    
}
