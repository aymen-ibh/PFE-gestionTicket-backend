package com.tn.saasProjectTicket.entity;

public class TokenObject {

	private String login;
	private Integer userId;
	private Integer idEmp;
	private String role;
	private Integer idEntreprise;
	private Boolean fActifEntreprise;
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(Integer idEmp) {
		this.idEmp = idEmp;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getIdEntreprise() {
		return idEntreprise;
	}
	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}
	public Boolean getfActifEntreprise() {
		return fActifEntreprise;
	}
	public void setfActifEntreprise(Boolean fActifEntreprise) {
		this.fActifEntreprise = fActifEntreprise;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public TokenObject(String login, Integer userId, Integer idEmp, String role, Integer idEntreprise,
			Boolean fActifEntreprise, String username) {
		super();
		this.login = login;
		this.userId = userId;
		this.idEmp = idEmp;
		this.role = role;
		this.idEntreprise = idEntreprise;
		this.fActifEntreprise = fActifEntreprise;
		this.username = username;
	}
	public TokenObject() {

	}
	
	
	
}
