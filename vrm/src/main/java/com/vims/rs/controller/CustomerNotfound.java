
package com.vims.rs.controller;



import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.qos.logback.classic.Logger;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotfound extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//static final long serialVersionUID = -7514407109669472202L;

	public CustomerNotfound(String searchTerm) {
		
		super("could not find Customer " + searchTerm + "'.");
	}
	
}