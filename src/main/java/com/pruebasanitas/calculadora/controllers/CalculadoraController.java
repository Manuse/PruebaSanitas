package com.pruebasanitas.calculadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebasanitas.calculadora.services.CalculadoraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CalculadoraController {

	@Autowired
	private CalculadoraService calculadoraService;

	@Operation(description = "Suma 2 números pasados por parámetros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suma realizada correctamente"),
            @ApiResponse(responseCode = "406", description = "Error en algún número introducido"),
    })
	@GetMapping("/sumar")
	public ResponseEntity<Double> sumar(@RequestParam String actual, @RequestParam String suma){
		return ResponseEntity.ok(calculadoraService.sumar(actual, suma));
	}

	@Operation(description = "Resta 2 números pasados por parámetros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resta realizada correctamente"),
            @ApiResponse(responseCode = "406", description = "Error en algún número introducido"),
    })
	@GetMapping("/restar")
	public ResponseEntity<Double> restar(@RequestParam String actual, @RequestParam String resta){
		return ResponseEntity.ok(calculadoraService.restar(actual, resta));
	}

	@Operation(description = "Multiplica 2 números pasados por parámetros")
	@ApiResponse(responseCode = "405", description = "Operación aún no permitida")
	@GetMapping("/multiplicar")
	public ResponseEntity<Double> multiplicar(@RequestParam String actual, @RequestParam String multiplica){
		throw new UnsupportedOperationException("Operación no soportada");
	}

	@Operation(description = "Divide 2 números pasados por parámetros")
	@ApiResponse(responseCode = "405", description = "Operación aún no permitida")
	@GetMapping("/dividir")
	public ResponseEntity<Double> dividir(@RequestParam String actual, @RequestParam String divide){
		throw new UnsupportedOperationException("Operación no soportada");
	}

}
