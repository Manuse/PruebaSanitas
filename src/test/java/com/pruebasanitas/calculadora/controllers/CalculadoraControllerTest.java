package com.pruebasanitas.calculadora.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebasanitas.calculadora.services.CalculadoraService;

@ExtendWith(MockitoExtension.class)
public class CalculadoraControllerTest {

	@InjectMocks
	private CalculadoraController calculadoraController;

	@Mock
	private CalculadoraService calculadoraService;

	@Test
	public void sumarTest() throws Exception {
		when(calculadoraService.sumar(Mockito.anyString(), Mockito.anyString())).thenReturn(5d);
		assertEquals(200, calculadoraController.restar("1", "4").getStatusCodeValue());
		assertEquals(5d, calculadoraController.sumar("1", "4").getBody());
	}

	@Test
	public void restarTest() {
		when(calculadoraService.restar(Mockito.anyString(), Mockito.anyString())).thenReturn(5d);
		assertEquals(200, calculadoraController.restar("9", "4").getStatusCodeValue());
		assertEquals(5d, calculadoraController.restar("9", "4").getBody());
	}

	@Test
	public void dividirTest() {
		RuntimeException ex = assertThrows(UnsupportedOperationException.class, () -> calculadoraController.dividir("9", "4"));
		assertEquals(ex.getMessage(), "Operación no soportada");

	}

	@Test
	public void multiplicarTest() {
		RuntimeException ex = assertThrows(UnsupportedOperationException.class, () -> calculadoraController.multiplicar("9", "4"));
		assertEquals(ex.getMessage(), "Operación no soportada");
	}
}
