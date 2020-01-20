package com.ceiba.adn.consultoriaabogados.dominio.unificacionpruebas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionArgumentos;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionEstadoInvalido;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionTipoConsulta;
import com.ceiba.adn.consultoriaabogados.dominio.validador.ValidadorArgumentos;

public class ArgumentosPruebas {
	private static final String ESTA_VACIO = "";
	private static final String CEDULA = "102078049";
	private static final String PENAL = "PENAL";
	private static final String JUDICIAL = "JUDICIAL";
	private static final String PAGADA = "PAGADA";
	private static final String OCUPADO = "OCUPADO";
	private static final String IDENTIFICACION_ESTA_VACIA = "Se debe ingresar la identificación del cliente";
	private static final String ESTADO_INVALIDO = "Se debe ingresar un tipo de valido de estado";
	private static final String TIPO_DE_CONSULTA_INVALIDO = "Se debe ingresar un tipo valido de consulta";

	@Test
	public void validarArgumentoVacios() {
		try {
			ValidadorArgumentos.validarRequeridos(ESTA_VACIO, IDENTIFICACION_ESTA_VACIA);
			fail();
		} catch (ExcepcionArgumentos e) {
			assertThat(e.getMessage()).isEqualTo(IDENTIFICACION_ESTA_VACIA);
		}
	}

	@Test
	public void validarArgumentosEstaNull() {
		try {
			ValidadorArgumentos.validarRequeridos(null, IDENTIFICACION_ESTA_VACIA);
			fail();
		} catch (ExcepcionArgumentos e) {
			assertThat(e.getMessage()).isEqualTo(IDENTIFICACION_ESTA_VACIA);
		}
	}

	@Test
	public void validarArgumentoVaciosCorrecto() {
		try {
			ValidadorArgumentos.validarRequeridos(CEDULA, IDENTIFICACION_ESTA_VACIA);
		} catch (ExcepcionArgumentos e) {
			assertThat(e.getMessage()).isEqualTo(IDENTIFICACION_ESTA_VACIA);
		}
	}

	@Test
	public void validarEstadoConsultaIncorrecto() {
		try {
			ValidadorArgumentos.validarEstadosConsulta(OCUPADO, ESTADO_INVALIDO);
			fail();
		} catch (ExcepcionEstadoInvalido e) {
			assertThat(e.getMessage()).isEqualTo(ESTADO_INVALIDO);
		}
	}

	@Test
	public void validarEstadoConsultaCorrecto() {
		try {
			ValidadorArgumentos.validarEstadosConsulta(PAGADA, ESTADO_INVALIDO);
		} catch (ExcepcionEstadoInvalido e) {
			assertThat(e.getMessage()).isEqualTo(ESTADO_INVALIDO);
		}
	}

	@Test
	public void validarTipoConsultaIncorrecto() {
		try {
			ValidadorArgumentos.validarTipoConsulta(PENAL, TIPO_DE_CONSULTA_INVALIDO);
			fail();
		} catch (ExcepcionTipoConsulta e) {
			assertThat(e.getMessage()).isEqualTo(TIPO_DE_CONSULTA_INVALIDO);
		}
	}

	@Test
	public void validarTipoConsultaCorrecto() {
		try {
			ValidadorArgumentos.validarTipoConsulta(JUDICIAL, TIPO_DE_CONSULTA_INVALIDO);
		} catch (ExcepcionTipoConsulta e) {
			assertThat(e.getMessage()).isEqualTo(TIPO_DE_CONSULTA_INVALIDO);
		}
	}
}
