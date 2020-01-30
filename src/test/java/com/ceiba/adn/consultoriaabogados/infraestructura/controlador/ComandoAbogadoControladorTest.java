package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionNoExisteConsultaAbogado;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AplicacionMock.class)
@SpringBootTest(classes = ConsultoriaAbogadosApplication.class)
@AutoConfigureMockMvc
public class ComandoAbogadoControladorTest {
	private static final String CONSULTA_ABOGADO_NO_EXISTE = "No se encontro la consulta en base de datos";
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

		JSONObject jsonConsultaComando = new JSONObject(
				"{\r\n" + "    \"nombre\": \"Andres Moreno\",\r\n" + "    \"identificacion\": \"1020456129\",\r\n"
						+ "    \"celular\": \"\",\r\n" + "    \"tipoConsultoria\": \"FAMILIAR\",\r\n"
						+ "    \"estado\": \"PAGADA\",\r\n" + "    \"fechaConsulta\": \"2020-01-30\"\r\n" + "}");

		this.mockMvc.perform(post("/api/comando/abogado").content(jsonConsultaComando.toString())
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void actualizarConsultaAbogadoNoExiste() throws Exception {
		JSONObject jsonConsultaComando = new JSONObject("{\r\n" + "    \"id\": 5,\r\n"
				+ "    \"nombre\": \"Andres Moreno\",\r\n" + "    \"identificacion\": \"1020456126\",\r\n"
				+ "    \"celular\": \"31770501\",\r\n" + "    \"tipoConsultoria\": \"FAMILIAR\",\r\n"
				+ "    \"estado\": \"PAGADA\",\r\n" + "    \"fechaConsulta\": \"2020-01-31\"\r\n" + "}");

		this.mockMvc
				.perform(put("/api/comando/abogado").content(jsonConsultaComando.toString())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.nombreExcepcion").value(ExcepcionNoExisteConsultaAbogado.class.getSimpleName()))
				.andExpect(jsonPath("$.mensaje").value(String.format(CONSULTA_ABOGADO_NO_EXISTE)));
		;
	}
}
