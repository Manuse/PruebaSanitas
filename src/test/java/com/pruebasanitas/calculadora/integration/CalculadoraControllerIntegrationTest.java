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
		this.mvc.perform(get("/sumar").param("actual", "1").param("suma", "4"))
				.andExpect(status().isOk()).andExpect(content().string("5.0"));
	}

	@Test
	public void restarTest() throws Exception {
		this.mvc.perform(get("/restar").param("actual", "9").param("resta", "4"))
				.andExpect(status().isOk()).andExpect(content().string("5.0"));
	}
}
