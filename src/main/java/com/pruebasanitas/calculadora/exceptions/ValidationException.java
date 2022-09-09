package com.pruebasanitas.calculadora.exceptions;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 4188779770532840926L;

	public ValidationException(String message) {
		super(message);
	}

}
