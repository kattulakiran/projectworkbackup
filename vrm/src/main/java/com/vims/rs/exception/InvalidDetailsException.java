package com.vims.rs.exception;
import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class InvalidDetailsException extends RuntimeException implements Serializable {

private static final long serialVersionUID = 1L;
	
	public InvalidDetailsException(String s) {
		super(s+" is invalid.");
	}
}
