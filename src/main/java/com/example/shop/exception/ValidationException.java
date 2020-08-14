package com.example.shop.exception;

public class ValidationException extends IllegalArgumentException {

    private static final long serialVersionUID = -3956768424512597143L;

    public ValidationException(String e) {
        super(e);
    }
}
