package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
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
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ComandoRespuesta;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.infraestructura.pruebasdatabuilder.ConsultaAbogadoPruebasDataBuilderComando;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AplicacionMock.class)
@SpringBootTest(classes = ConsultoriaAbogadosApplication.class)
@AutoConfigureMockMvc
public class ConsultaAbogadoControladorTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;


	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void crearConsultaAbogado() throws Exception {
		ConsultaAbogadoPruebasDataBuilderComando consultaBuilder = new ConsultaAbogadoPruebasDataBuilderComando();
		ConsultaAbogadoComando consultaAbogado = consultaBuilder.build();
		JSONObject jsonConsultaComando = new JSONObject(consultaAbogado);
		ComandoRespuesta<ConsultaAbogadoComando> comandoRespuesta = new ComandoRespuesta<>(consultaAbogado);
		JSONObject jsonComandoRespuesta = new JSONObject(comandoRespuesta);
		this.mockMvc.perform(post("/api/comando/abogado").content(jsonConsultaComando.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(jsonComandoRespuesta.toString()));
	}
}
