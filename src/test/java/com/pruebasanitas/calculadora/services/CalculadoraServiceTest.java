package com.pruebasanitas.calculadora.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pruebasanitas.calculadora.exceptions.ValidationException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalculadoraServiceTest {

	@Autowired
	private CalculadoraService calculadoraService;

	@Test
	public void sumarTest() {
		assertEquals(calculadoraService.sumar("1", "2"), 3d);
	}

	@Test
	public void restarTest() {
		assertEquals(calculadoraService.restar("5,1", "2,1"), 3d);
	}

	@Test
	public void sumarExceptionTest() {
		RuntimeException ex = assertThrows(ValidationException.class, () -> calculadoraService.sumar("a", "s"));
		assertEquals(ex.getMessage(), "Unos de los datos introducidos no es un número");
	}

	@Test
	public void restarExceptionTest() {
		RuntimeException ex = assertThrows(ValidationException.class, () -> calculadoraService.restar("1", "s"));
		assertEquals(ex.getMessage(), "Unos de los datos introducidos no es un número");
	}


}
