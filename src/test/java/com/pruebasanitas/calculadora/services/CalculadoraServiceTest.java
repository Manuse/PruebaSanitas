package com.pruebasanitas.calculadora.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalculadoraServiceTest {

	@Autowired
	private CalculadoraService calculadoraService;

	@Test
	public void sumarTest() {
		assertEquals(calculadoraService.sumar(1d, 2d), 3d);
	}

	@Test
	public void restarTest() {
		assertEquals(calculadoraService.restar(5d, 2d), 3d);
	}
}
