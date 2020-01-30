package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.consultoriaabogados.AplicacionMock;
import com.ceiba.adn.consultoriaabogados.ConsultoriaAbogadosApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AplicacionMock.class)
@SpringBootTest(classes = ConsultoriaAbogadosApplication.class)
@AutoConfigureMockMvc
public class ConsultaAbogadoControladorTest {

	private static final String URL = "/api/consulta/abogado";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void listarConsultasAbogado() throws Exception {
		this.mockMvc.perform(get(URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

//	@Test
//	public void listarConsultaAbogadoId() throws Exception {
//		this.mockMvc.perform(get(URL + "/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//	}

}
