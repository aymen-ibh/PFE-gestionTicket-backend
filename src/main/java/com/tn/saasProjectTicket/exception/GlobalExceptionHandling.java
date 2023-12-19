package com.tn.saasProjectTicket.exception;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<?> emailExistException(EmailAlreadyExistException exception) {
        return ResponseEntity
        		.status(HttpStatus.BAD_REQUEST)
        		.body(exception.getMessage());
    }
	public ResponseEntity<?> userAlreadyExistException(UserAlreadyExistException exception){
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(exception.getMessage());
	}

}
