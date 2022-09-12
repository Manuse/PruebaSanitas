package com.pruebasanitas.calculadora.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CalculadoraControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void sumarTest() throws Exception {
		mvc.perform(get("/sumar").param("actual", "1").param("suma", "4"))
				.andExpect(status().isOk()).andExpect(content().string("5.0"));
	}

	@Test
	public void restarTest() throws Exception {
		mvc.perform(get("/restar").param("actual", "9").param("resta", "4"))
				.andExpect(status().isOk()).andExpect(content().string("5.0"));
	}

	@Test
	public void sumarExceptionTest() throws Exception {
		mvc.perform(get("/sumar")
				.param("actual", "a")
				.param("suma", "4"))
		.andExpect(status().isNotAcceptable())
		.andExpect(content().string("Unos de los datos introducidos no es un número"));
	}

	@Test
	public void restarExceptionTest() throws Exception {
		mvc.perform(get("/restar")
				.param("actual", "9")
				.param("resta", "z"))
		.andExpect(status().isNotAcceptable())
		.andExpect(content().string("Unos de los datos introducidos no es un número"));
	}

	@Test
	public void multiplicarExceptionTest() throws Exception {
		mvc.perform(get("/multiplicar")
				.param("actual", "9")
				.param("multiplica", "4"))
		.andExpect(status().isMethodNotAllowed())
		.andExpect(content().string("Operación no soportada"));
	}

	@Test
	public void dividirExceptionTest() throws Exception {
		mvc.perform(get("/dividir")
				.param("actual", "9")
				.param("divide", "4"))
		.andExpect(status().isMethodNotAllowed())
		.andExpect(content().string("Operación no soportada"));
	}
}
