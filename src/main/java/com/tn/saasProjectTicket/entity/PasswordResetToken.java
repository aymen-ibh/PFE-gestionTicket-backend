package com.tn.saasProjectTicket.entity;

import java.time.LocalDateTime;

public class PasswordResetToken {
	
	private String token;
	private String userEmail;
	//private Integer userId;
	private LocalDateTime expiryDate;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/*public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId; 
	} */
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}
	public PasswordResetToken() {
		super();
	}
	public PasswordResetToken(String token, String userEmail, LocalDateTime expiryDate) {
		super();
		this.token = token;
		this.userEmail = userEmail;
		this.expiryDate = expiryDate;
	}
	
	
}
