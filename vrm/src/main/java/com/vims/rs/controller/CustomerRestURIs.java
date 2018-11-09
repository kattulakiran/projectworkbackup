package com.vims.rs.controller;

public interface CustomerRestURIs {

	public static final String GET_ALL_CUSTOMERS = "/customer/list";
	public static final String SEARCH_CUSTOMER = "/customer/search/{searchterm}";
	public static final String CREATE_CUSTOMER = "/customer/create";
	//public static final String DELETE_CUSTOMER = "/customer/delete/{customer_id}";
	public static final String ROOT = "/customermodule";

     public static final String UPDATE_CUSTOMER = "/customer/update/{searchterm}";
     public static final String LOGIN_CUSTOMER = "/customer/login/{searchterm}";
     
}

