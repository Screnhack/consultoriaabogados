package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.consultoriaabogados.ApplicationMock;
import com.ceiba.adn.consultoriaabogados.ConsultoriaAbogadosApplication;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ComandoRespuesta;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.infraestructura.pruebasdatabuilder.ConsultaAbogadoPruebasDataBuilderComando;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@SpringBootTest(classes = ConsultoriaAbogadosApplication.class)
public class ComandoAbogadoControladorTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private static final String IDENTIFICACION = "1020145562";
	private static final String FECHA_CONSULTA_STRING = "2020-01-22";
	private static final String NOMBRE_CLIENTE = "Juan Camilo Sanmiguel";
	private static final String CELULAR = "3174526532";
	private static final String PAGADA = "PAGADA";
	private static final String FAMILIAR = "FAMILIAR";


	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void listaDeConsultaAbogados() throws Exception {
		// Act
		this.mockMvc.perform(get("/api/consulta/abogado")).andExpect(status().isAccepted())
				// Assert
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void crearConsultaAbogado() throws Exception {
		ConsultaAbogadoPruebasDataBuilderComando consultaAbogadoBuilder = new ConsultaAbogadoPruebasDataBuilderComando()
				.conNombre(NOMBRE_CLIENTE).conIdentificacion(IDENTIFICACION).conCelular(CELULAR)
				.conTipoConsultoria(FAMILIAR).conEstado(PAGADA).conFechaConsulta(FECHA_CONSULTA_STRING);
		ConsultaAbogadoComando consultaAbogado = consultaAbogadoBuilder.build();
		JSONObject jsonConsultaAbogadoComando = new JSONObject(consultaAbogado);
		ComandoRespuesta<ConsultaAbogadoComando> comandoRespuesta = new ComandoRespuesta<>(consultaAbogado);
		JSONObject jsonConsultaAbogadoComandoRespuesta = new JSONObject(comandoRespuesta);
		this.mockMvc
				.perform(post("/api/comando/abogado").content(jsonConsultaAbogadoComando.toString())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(jsonConsultaAbogadoComandoRespuesta.toString()));
	}
}
