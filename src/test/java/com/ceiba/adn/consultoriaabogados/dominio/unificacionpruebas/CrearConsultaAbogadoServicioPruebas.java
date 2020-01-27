package com.ceiba.adn.consultoriaabogados.dominio.unificacionpruebas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.adn.consultoriaabogados.dominio.databuilder.ConsultaAbogadoPruebaDataBuilder;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionClienteConsultaDia;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionDiaProhibidos;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionTipoConsulta;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;
import com.ceiba.adn.consultoriaabogados.dominio.servicio.CrearConsultaAbogadoServicio;
import com.ceiba.adn.consultoriaabogados.dominio.util.FormatearFechas;

@SpringBootTest
public class CrearConsultaAbogadoServicioPruebas {

	private ConsultaAbogadoRepositorio repositorio;
	private CrearConsultaAbogadoServicio servicio;
	private ConsultaAbogado consultaAbogado;
	private ConsultaAbogadoPruebaDataBuilder consultaBuilder;
	private FormatearFechas formatearFechas;
	private static final String IDENTIFICACION = "1020145562";
	private static final String FECHA_CONSULTA_STRING = "2020-01-22";
	private static final String FECHA_CONSULTA_STRING_SABADO = "2020-01-18";
	private static final String FECHA_CONSULTA_STRING_DOMINGO = "2020-01-19";
	private static final String FECHA_CONSULTA_STRING_LUNES = "2020-01-20";
	private static final String NOMBRE_CLIENTE = "Juan Camilo Sanmiguel";
	private static final String CELULAR = "3174526532";
	private static final String ESTADO_VALIDO = "PAGADO";
	private static final String FAMILIAR = "FAMILIAR";
	private static final float PRECIO_CONSULTA_FAMILIAR = 100000;
	private static final float PRECIO_CONSULTA_FAMILIAR_AUMENTO = 150000;
	private static final String JUDICIAL = "JUDICIAL";
	private static final float PRECIO_CONSULTA_JUDICIAL = 200000;
	private static final String ECONOMICO = "ECONOMICO";
	private static final float PRECIO_CONSULTA_ECONOMICO = 110000;
	private static final String PENAL = "PENAL";
	private static final String DIA_DOMINGO = "El Domingo no se pueden agendar citas";
	private static final String TIPO_DE_CONSULTA_INVALIDO = "Se debe ingresar un tipo valido de consulta";
	private static final String DIA_LUNES = "El lunes no se pueden agendar citas de tipo judicial";
	private static final String CLIENTE_CONSULTA_DIA_EXISTE = "El Cliente ya tiene cita para el dia seleccionado";

	@Before
	public void setUp() {
		this.repositorio = mock(ConsultaAbogadoRepositorio.class);
		this.formatearFechas = new FormatearFechas();
	}

	@Test
	public void build() {
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		assertNotNull(this.repositorio);
		assertNotNull(this.servicio);
	}

	@Test
	public void crearConsultaAbogado() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conNombre(NOMBRE_CLIENTE)
				.conIdentificacion(IDENTIFICACION).conCelular(CELULAR).conTipoConsultoria(FAMILIAR)
				.conEstado(ESTADO_VALIDO)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		ConsultaAbogado consultaNueva = this.consultaBuilder.build();
		when(this.repositorio.crearConsulta(this.consultaAbogado)).thenReturn(consultaNueva);
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		ConsultaAbogado consultaRespuesta = this.servicio.ejecutar(this.consultaAbogado);
		assertThat(consultaRespuesta).isEqualTo(consultaNueva);
	}

	@Test
	public void validarDiaDomingo() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder()
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING_DOMINGO));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		try {

			this.consultaAbogado
					.validarConsultaDiaDomingo();
			fail();
		} catch (ExcepcionDiaProhibidos e) {
			assertThat(e.getMessage()).isEqualTo(DIA_DOMINGO);
		}
	}

	@Test
	public void validarDiaNoDomingo() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder()
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING_LUNES));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		try {
			this.consultaAbogado
					.validarConsultaDiaDomingo();
		} catch (ExcepcionDiaProhibidos e) {
			assertThat(e.getMessage()).isEqualTo(DIA_DOMINGO);
		}
	}

	@Test
	public void validarDialunes() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder()
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING_LUNES));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		try {
			this.consultaAbogado.validarConsultaDiaLunesJudicial();
			fail();
		} catch (ExcepcionDiaProhibidos e) {
			assertThat(e.getMessage()).isEqualTo(DIA_LUNES);
		}
	}

	@Test
	public void validarDiaSabado() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder()
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING_SABADO));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		assertTrue(this.consultaAbogado
				.validarConsultaDiaSabado());
	}

	@Test
	public void validarPrecioTipoConsultaIncorrecto() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conTipoConsultoria(PENAL)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		try {
			this.consultaAbogado.precioTipoConsulta();
			fail();
		} catch (ExcepcionTipoConsulta e) {
			assertThat(e.getMessage()).isEqualTo(TIPO_DE_CONSULTA_INVALIDO);
		}
	}

	@Test
	public void validarPrecioTipoConsultaFamiliarCorrecto() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conTipoConsultoria(FAMILIAR)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		this.consultaAbogado.precioTipoConsulta();
		assertThat(this.consultaAbogado.getPrecio()).isEqualTo(PRECIO_CONSULTA_FAMILIAR);
	}

	@Test
	public void validarPrecioTipoConsultaJudicialCorrecto() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conTipoConsultoria(JUDICIAL)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		this.consultaAbogado.precioTipoConsulta();
		assertThat(this.consultaAbogado.getPrecio()).isEqualTo(PRECIO_CONSULTA_JUDICIAL);
	}

	@Test
	public void validarPrecioTipoConsultaEconomicoCorrecto() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conTipoConsultoria(ECONOMICO)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		this.consultaAbogado.precioTipoConsulta();
		assertThat(this.consultaAbogado.getPrecio()).isEqualTo(PRECIO_CONSULTA_ECONOMICO);
	}

	@Test
	public void validarPrecioTipoConsultaFamiliarCorrectoConAumento() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conTipoConsultoria(FAMILIAR)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING_SABADO));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		this.consultaAbogado.precioTipoConsulta();
		assertThat(this.consultaAbogado.getPrecio()).isEqualTo(PRECIO_CONSULTA_FAMILIAR_AUMENTO);
	}

	@Test
	public void validarConsultasClienteDiaCorrecto() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conIdentificacion(IDENTIFICACION)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		when(this.repositorio.validarConsultasClienteDia(IDENTIFICACION,
				this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING))).thenReturn(true);
		assertTrue(this.repositorio.validarConsultasClienteDia(IDENTIFICACION,
				this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING)));
	}

	@Test
	public void validarConsultasClienteDiaIncorrecto() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conIdentificacion(IDENTIFICACION)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		when(this.repositorio.validarConsultasClienteDia(IDENTIFICACION,
				this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING))).thenReturn(false);
		assertFalse(this.repositorio.validarConsultasClienteDia(IDENTIFICACION,
				this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING)));
	}

	@Test
	public void validarConsultasClienteDiaExiste() {
		this.consultaBuilder = new ConsultaAbogadoPruebaDataBuilder().conIdentificacion(IDENTIFICACION)
				.conFechaConsulta(this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
		this.consultaAbogado = this.consultaBuilder.build();
		when(this.repositorio.validarConsultasClienteDia(IDENTIFICACION,
				this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING))).thenReturn(true);
		this.servicio = new CrearConsultaAbogadoServicio(this.repositorio);
		try {
			this.servicio.validarConsultasClienteDia(IDENTIFICACION,
					this.formatearFechas.formatearFechaDate(FECHA_CONSULTA_STRING));
			fail();
		} catch (ExcepcionClienteConsultaDia e) {
			assertThat(e.getMessage()).isEqualTo(CLIENTE_CONSULTA_DIA_EXISTE);

		}
	}

}
