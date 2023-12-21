package com.tn.saasProjectTicket.exception.domain;

import org.springframework.stereotype.Component;


public class UserAlreadyExistException extends RuntimeException {
	public UserAlreadyExistException(String message) {
		super(message);
	}
}
