package com.pruebasanitas.calculadora.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.pruebasanitas.calculadora.services.CalculadoraService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CalculadoraControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CalculadoraService calculadoraService;

	@Test
	public void sumarTest() throws Exception {
		when(calculadoraService.sumar(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(5d);
		this.mvc.perform(get("/sumar").param("actual", "1").param("suma", "4"))
				.andExpect(status().isOk()).andExpect(content().string("5.0"));
	}

	@Test
	public void restarTest() throws Exception {
		when(calculadoraService.restar(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(5d);
		this.mvc.perform(get("/restar").param("actual", "9").param("resta", "4"))
				.andExpect(status().isOk()).andExpect(content().string("5.0"));
	}
}
