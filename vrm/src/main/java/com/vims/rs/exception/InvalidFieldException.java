package com.vims.rs.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidFieldException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public InvalidFieldException(String field) {
		super("Invalid field " + field + "'.");
	}
	
}
