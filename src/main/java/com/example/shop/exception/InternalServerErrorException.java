package com.example.shop.exception;


public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 7727337931580940344L;

	public InternalServerErrorException(String message) {
		super(message);
	}

	public InternalServerErrorException(Throwable cause) {
		super(cause);
	}

	public InternalServerErrorException(String message, Throwable cause) {
		super(message, cause);
	}

}
