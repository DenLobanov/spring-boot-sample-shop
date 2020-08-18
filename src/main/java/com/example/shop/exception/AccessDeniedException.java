package com.example.shop.exception;

import javax.servlet.http.HttpServletResponse;

public class AccessDeniedException extends AbstractApplicationException {

	private static final long serialVersionUID = 8211399516070213968L;

	public AccessDeniedException(String s) {
		super(s, HttpServletResponse.SC_FORBIDDEN);
	}
}
