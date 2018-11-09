package com.vims.rs.exception;

import java.io.Serializable;

public class ClaimNotFoundException  extends RuntimeException implements Serializable{

	
	private static final long serialVersionUID = -9079599545356989460L;

	public ClaimNotFoundException(String s){
		super("claim does not exist with policy id: "+s);
	}
	
}
