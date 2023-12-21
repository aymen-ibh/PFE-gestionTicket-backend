package com.tn.saasProjectTicket.exception.domain;

import org.springframework.stereotype.Component;


public class EmailAlreadyExistException extends RuntimeException {
	public EmailAlreadyExistException(String message) {
        super(message);
    }
}
