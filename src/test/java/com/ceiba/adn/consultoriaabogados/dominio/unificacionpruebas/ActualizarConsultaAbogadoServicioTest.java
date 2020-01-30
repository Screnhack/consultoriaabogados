package com.ceiba.adn.consultoriaabogados.dominio.unificacionpruebas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.adn.consultoriaabogados.dominio.databuilder.ConsultaAbogadoPruebaDataBuilder;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionNoExisteConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;
import com.ceiba.adn.consultoriaabogados.dominio.servicio.ActualizarConsultaAbogadoServicio;
import com.ceiba.adn.consultoriaabogados.dominio.util.FormatearFechas;

@SpringBootTest
public class ActualizarConsultaAbogadoServicioTest {
	private ConsultaAbogadoRepositorio repositorio;
	private ActualizarConsultaAbogadoServicio servicio;
	private ConsultaAbogado consultaAbogado;
	private ConsultaAbogadoPruebaDataBuilder consultaBuilder;
	private FormatearFechas formatearFechas;
	private static final Long ID_CONSULTA = (long) 1;
	private static final String IDENTIFICACION = "1020145562";
	private static final String FECHA_CONSULTA_STRING = "2020-01-22";
	private static final String NOMBRE_CLIENTE = "Juan Camilo Sanmiguel";
	private static final String CELULAR = "3174526532";
	private static final String ESTADO_VALIDO = "PAGADO";
	private static final String FAMILIAR = "FAMILIAR";
	private static final String CONSULTA_ABOGADO_NO_EXISTE = "No se encontro la consulta en base de datos";

	@Before
	public void setUp() {
		this.repositorio = mock(ConsultaAbogadoRepositorio.class);
		this.formatearFechas = new FormatearFechas();
	}

	@Test
	public void build() {
		this.servicio = new ActualizarConsultaAbogadoServicio(this.repositorio);
		assertNotNull(this.repositorio);
		assertNotNull(this.servicio);
	}


	@Test
	public void actualizarConsultaAbogadoNoExiste() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conId(ID_CONSULTA).conNombre(NOMBRE_CLIENTE)
				.conIdentificacion(IDENTIFICACION).conCelular(CELULAR).conTipoConsultoria(FAMILIAR)
				.conEstado(ESTADO_VALIDO)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new ActualizarConsultaAbogadoServicio(this.repositorio);
		try {
			this.servicio.actualizarConsultaAbogado(this.consultaAbogado);
			fail();
		} catch (ExcepcionNoExisteConsultaAbogado e) {
			assertThat(e.getMessage()).isEqualTo(CONSULTA_ABOGADO_NO_EXISTE);
		}
	}
}
