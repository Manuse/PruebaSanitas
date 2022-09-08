package com.pruebasanitas.calculadora.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebasanitas.calculadora.enums.OperacionesEnum;
import com.pruebasanitas.calculadora.services.CalculadoraService;

import io.corp.calculator.TracerAPI;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	@Autowired
	private TracerAPI traceApi;

	@Override
	public double sumar(double actual, double suma) {
		return calcular(actual, suma, OperacionesEnum.SUMAR);
	}

	@Override
	public double restar(double actual, double resta) {
		return calcular(actual, resta, OperacionesEnum.RESTAR);
	}

	private double calcular(double numero1, double numero2, OperacionesEnum operacion) {
		BigDecimal bdNumero1 = BigDecimal.valueOf(numero1);
		BigDecimal bdNumero2 = BigDecimal.valueOf(numero2);
		BigDecimal resultado = BigDecimal.ZERO;

		switch (operacion) {

		case SUMAR:
			resultado = bdNumero1.add(bdNumero2);
			break;

		case RESTAR:
			resultado = bdNumero1.subtract(bdNumero2);
			break;

		}

		traceApi.trace(resultado.doubleValue());

		return resultado.doubleValue();

	}
}
