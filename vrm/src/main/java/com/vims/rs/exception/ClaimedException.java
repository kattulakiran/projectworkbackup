package com.vims.rs.exception;

import java.io.Serializable;

public class ClaimedException extends RuntimeException implements Serializable{

	
	private static final long serialVersionUID = 1657090285753940095L;

	public ClaimedException(String s){
		super(s);
	}
}
