package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.consultoriaabogados.ConsultoriaAbogadosApplication;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.infraestructura.pruebasdatabuilder.ConsultaAbogadoPruebasDataBuilderComando;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsultoriaAbogadosApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ComandoAbogadoControladorPruebas {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void clear() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(null).build();
	}

	@Test
	public void createConsultaAbogadoComando() throws Exception {
		ConsultaAbogadoComando comandoConsultaAbogado = new ConsultaAbogadoPruebasDataBuilderComando().build();
		mockMvc.perform(post("/api/comando/abogado").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoConsultaAbogado))).andExpect(status().isOk());
	}

}
