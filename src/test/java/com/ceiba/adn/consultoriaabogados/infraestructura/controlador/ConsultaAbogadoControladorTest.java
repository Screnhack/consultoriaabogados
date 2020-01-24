package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.dominio.util.FormatearFechas;
import com.ceiba.adn.consultoriaabogados.infraestructura.pruebasdatabuilder.ConsultaAbogadoPruebasDataBuilderComando;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AplicacionMock.class)
@SpringBootTest(classes = ConsultoriaAbogadosApplication.class)
@AutoConfigureMockMvc
public class ConsultaAbogadoControladorTest {
	private FormatearFechas formatearFechas;

	private static final String IDENTIFICACION = "1020145563";
	private static final String FECHA_CONSULTA_STRING = "22/01/2020";
	private static final String NOMBRE_CLIENTE = "Juan Camilo Sanmiguel";
	private static final String CELULAR = "3174526532";
	private static final String ESTADO_VALIDO = "PAGADA";
	private static final String FAMILIAR = "FAMILIAR";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		this.formatearFechas = new FormatearFechas();
	}

	@Test
	public void crearConsultaAbogado() throws Exception {
		ConsultaAbogadoPruebasDataBuilderComando consultaBuilder = new ConsultaAbogadoPruebasDataBuilderComando()
				.conNombre(NOMBRE_CLIENTE).conIdentificacion(IDENTIFICACION).conCelular(CELULAR)
				.conTipoConsultoria(FAMILIAR).conEstado(ESTADO_VALIDO)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		ConsultaAbogadoComando consultaAbogado = consultaBuilder.build();
		JSONObject jsonConsultaComando = new JSONObject(consultaAbogado);
		this.mockMvc.perform(post("/api/comando/abogado").content(jsonConsultaComando.toString())
				.contentType(MediaType.APPLICATION_JSON));
	}
}
