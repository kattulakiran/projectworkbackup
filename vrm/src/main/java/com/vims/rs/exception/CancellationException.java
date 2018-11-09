package com.vims.rs.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CancellationException extends RuntimeException  implements Serializable {
public CancellationException(String s){
		
		super("Invalid " + s);
		
	}

}