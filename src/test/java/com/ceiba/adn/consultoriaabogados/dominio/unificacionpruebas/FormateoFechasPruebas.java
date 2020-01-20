package com.ceiba.adn.consultoriaabogados.dominio.unificacionpruebas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionFormatoFecha;
import com.ceiba.adn.consultoriaabogados.dominio.util.FormatearFechas;

public class FormateoFechasPruebas {

	private static final String FORMATO_FECHA_STRING = "2020-01-20";
	private static final String FORMATO_FECHA_STRING_INVALIDO = "20202001";
	private static final String FORMATO_FECHA_INVALIDO = "Formato de fecha Invalido";

	private FormatearFechas formatearFechas;

	@Before
	public void setUp() {
		this.formatearFechas = new FormatearFechas();
	}

	@Test
	public void validarFormateoFechaString() {
		String fechaFormateadaString;
		fechaFormateadaString = this.formatearFechas
				.formatearFechaString(this.formatearFechas.formatearFechaDate(FORMATO_FECHA_STRING));
		assertThat(fechaFormateadaString).isEqualTo(FORMATO_FECHA_STRING);
	}

	@Test
	public void validarFormateoFechaDateCorrecto() {
		Date fechaFormateadaDate;
		try {
			fechaFormateadaDate = this.formatearFechas.formatearFechaDate(FORMATO_FECHA_STRING);
			assertThat(fechaFormateadaDate).isEqualTo(this.formatearFechas.formatearFechaDate(FORMATO_FECHA_STRING));
		} catch (ExcepcionFormatoFecha e) {
			assertThat(e.getMessage()).isEqualTo(FORMATO_FECHA_INVALIDO);
		}
	}

	@Test
	public void validarFormateoFechaDateIncorrecto() {
		try {
			this.formatearFechas.formatearFechaDate(FORMATO_FECHA_STRING_INVALIDO);
			fail();
		} catch (ExcepcionFormatoFecha e) {
			assertThat(e.getMessage()).isEqualTo(FORMATO_FECHA_INVALIDO);
		}
	}

}
