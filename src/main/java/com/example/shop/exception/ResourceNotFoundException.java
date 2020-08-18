package com.example.shop.exception;

import javax.servlet.http.HttpServletResponse;


public class ResourceNotFoundException extends AbstractApplicationException {

	private static final long serialVersionUID = 1748847894540545207L;

	public ResourceNotFoundException(String s) {
		super(s, HttpServletResponse.SC_NOT_FOUND);
	}
}
