package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.consultoriaabogados.ConsultoriaAbogadosApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsultoriaAbogadosApplication.class)
@ComponentScan("com.ceiba.adn")
@AutoConfigureMockMvc
@WebMvcTest(controllers = ComandoAbogadoControlador.class)
@TestPropertySource(locations = "classpath:applicationintegratetest.properties")
public class ComandoAbogadoControladorPruebas {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

//	private static final String IDENTIFICACION = "1020145562";
//	private static final String FECHA_CONSULTA_STRING = "2020-01-22";
//	private static final String NOMBRE_CLIENTE = "Juan Camilo Sanmiguel";
//	private static final String CELULAR = "3174526532";
//	private static final String ESTADO_VALIDO = "PAGADO";
//	private static final String FAMILIAR = "FAMILIAR";

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testHelloEndPoint() throws Exception {
		this.mockMvc.perform(get("/api/comando/abogado/hello")).andExpect(status().isOk())
				.andExpect(content().string("Hola Mundo"));
	}

	@Test
	public void testHelloEndpointIsOK() throws Exception {
		this.mockMvc.perform(get("/api/comando/abogado/hello")).andExpect(status().isOk())
				.andExpect(content().string("Hola Mundo"));
	}

//	@Test
//	public void crear() throws Exception {
//		ConsultaAbogadoPruebasDataBuilderComando consultaAbogadoComando = new ConsultaAbogadoPruebasDataBuilderComando()
//				.conNombre(NOMBRE_CLIENTE).conIdentificacion(IDENTIFICACION).conCelular(CELULAR)
//				.conTipoConsultoria(FAMILIAR).conEstado(ESTADO_VALIDO).conFechaConsulta(FECHA_CONSULTA_STRING);
//		ConsultaAbogadoComando consultaAbogado = consultaAbogadoComando.build();
//		JSONObject jsonConsultaAbogadoComando = new JSONObject(consultaAbogado);
//		ComandoRespuesta<ConsultaAbogadoComando> comandoRespuesta = new ComandoRespuesta<>(consultaAbogado);
//		JSONObject jsonConsultaComandoRespuesta = new JSONObject(comandoRespuesta);
//		mockMvc.perform(post("/api/comando/abogado").contentType(MediaType.APPLICATION_JSON)
//				.content(jsonConsultaAbogadoComando.toString())).andExpect(status().isOk())
//				.andExpect(content().json(jsonConsultaComandoRespuesta.toString()));
//	}

}
