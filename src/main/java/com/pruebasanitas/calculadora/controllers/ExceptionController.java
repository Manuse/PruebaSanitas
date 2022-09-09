package com.pruebasanitas.calculadora.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pruebasanitas.calculadora.exceptions.ValidationException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> handleValidationException(ValidationException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(UnsupportedOperationException.class)
	public ResponseEntity<String> handleUnsupportedOperationException(UnsupportedOperationException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
	}

}
