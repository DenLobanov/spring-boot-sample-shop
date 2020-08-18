package com.example.shop.exception;

import javax.servlet.http.HttpServletResponse;


public class ValidationException extends AbstractApplicationException {

	private static final long serialVersionUID = 3258530133673179573L;

	public ValidationException(String s) {
		super(s, HttpServletResponse.SC_BAD_REQUEST);
	}
}
