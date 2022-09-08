package com.pruebasanitas.calculadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebasanitas.calculadora.services.CalculadoraService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CalculadoraController {

	@Autowired
	private CalculadoraService calculadoraService;

	@ApiOperation(value = "Suma 2 números pasados por parámetros")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suma realizada correctamente"),
            @ApiResponse(code = 400, message = "Error en algun número introducido"),
    })
	@GetMapping("/sumar")
	public ResponseEntity<Double> sumar(@RequestParam double actual, @RequestParam double suma){
		return ResponseEntity.ok(calculadoraService.sumar(actual, suma));
	}

	@ApiOperation(value = "Resta 2 números pasados por parámetros")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resta realizada correctamente"),
            @ApiResponse(code = 400, message = "Error en algun número introducido"),
    })
	@GetMapping("/restar")
	public ResponseEntity<Double> restar(@RequestParam double actual, @RequestParam double resta){
		return ResponseEntity.ok(calculadoraService.restar(actual, resta));
	}

}
