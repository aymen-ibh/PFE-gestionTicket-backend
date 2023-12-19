package com.tn.saasProjectTicket.exception.domain;

public class EmailAlreadyExistException extends RuntimeException {
	public EmailAlreadyExistException(String message) {
        super(message);
    }
}
