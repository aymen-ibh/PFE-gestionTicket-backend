package com.tn.saasProjectTicket.exception.domain;

public class UserAlreadyExistException extends RuntimeException {
	public UserAlreadyExistException(String message) {
		super(message);
	}
}
