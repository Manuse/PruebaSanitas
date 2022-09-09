package com.pruebasanitas.calculadora.services.impl;

import java.math.BigDecimal;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebasanitas.calculadora.enums.OperacionesEnum;
import com.pruebasanitas.calculadora.exceptions.ValidationException;
import com.pruebasanitas.calculadora.services.CalculadoraService;

import io.corp.calculator.TracerAPI;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	@Autowired
	private TracerAPI traceApi;

	private final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

	@Override
	public double sumar(String actual, String suma) {
		validateOnlyNumber(actual, suma);
		return calcular(actual, suma, OperacionesEnum.SUMAR);
	}

	@Override
	public double restar(String actual, String resta) {
		validateOnlyNumber(actual, resta);
		return calcular(actual, resta, OperacionesEnum.RESTAR);
	}

	private double calcular(String numero1, String numero2, OperacionesEnum operacion) {
		BigDecimal bdNumero1 = new BigDecimal(numero1.replace(",", "."));
		BigDecimal bdNumero2 = new BigDecimal(numero2.replace(",", "."));
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

	private void validateOnlyNumber(String... numbers) {
		if(Stream.of(numbers)
		.map(n -> n != null ? n.replace(",", ".") : null)
		.anyMatch(this::isNonNumeric)){
			throw new ValidationException("Unos de los datos introducidos no es un número");
		}
	}

	private boolean isNonNumeric(String strNum) {
	    if (strNum == null) {
	        return true;
	    }
	    return !PATTERN.matcher(strNum).matches();
	}
}
