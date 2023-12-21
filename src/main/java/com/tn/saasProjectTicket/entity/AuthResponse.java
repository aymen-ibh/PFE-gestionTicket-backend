package com.tn.saasProjectTicket.entity;

public class AuthResponse {
	
	private int httpStatusCode;
	private String token;
	
	
	public AuthResponse(int httpStatusCode, String token) {
		super();
		this.httpStatusCode = httpStatusCode;
		this.token = token;
	}


	public int getHttpStatusCode() {
		return httpStatusCode;
	}


	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	

}
