package com.pruebasanitas.calculadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pruebasanitas.calculadora.services.CalculadoraService;

@RestController
//@RequestMapping("/")
public class CalculadoraController implements OperacionApiDelegate {

	@Autowired
	private CalculadoraService calculadoraService;

	@Override
	public ResponseEntity<Void> dividir(String actual, String divide) {
		throw new UnsupportedOperationException("Operación no soportada");
	}

	@Override
	public ResponseEntity<Void> multiplicar(String actual, String multiplica) {
		throw new UnsupportedOperationException("Operación no soportada");
	}

	@Override
	public ResponseEntity<Double> restar(String actual, String resta) {
		return ResponseEntity.ok(calculadoraService.restar(actual, resta));
	}

	@Override
	public ResponseEntity<Double> sumar(String actual, String suma) {
		return ResponseEntity.ok(calculadoraService.sumar(actual, suma));
	}

}
