package com.ceiba.adn.consultoriaabogados.dominio.validador;

import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionArgumentos;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionEstadoInvalido;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionTipoConsulta;

public class ValidadorArgumentos {
	private static final String ESTA_VACIO = "";
	private static final String FAMILIAR = "FAMILIAR";
	private static final String JUDICIAL = "JUDICIAL";
	private static final String ECONOMICO = "ECONOMICO";
	private static final String PENDIENTE = "PENDIENTE";
	private static final String PAGADA = "PAGADA";
	private static final String REALIZADA = "REALIZADA";
	private static final String CANCELADA = "CANCELADA";

	private ValidadorArgumentos() {
	}

	public static void validarRequeridos(Object valor, String mensaje) {
		if (valor == null || valor.equals(ESTA_VACIO)) {
			throw new ExcepcionArgumentos(mensaje);
		}
	}

	public static void validarEstadosConsulta(Object valor, String mensaje) {
		if (!valor.equals(PENDIENTE) && !valor.equals(PAGADA) && !valor.equals(REALIZADA) && !valor.equals(CANCELADA)) {
			throw new ExcepcionEstadoInvalido(mensaje);
		}
	}

	public static void validarTipoConsulta(Object valor, String mensaje) {
		if (!valor.equals(FAMILIAR) && !valor.equals(JUDICIAL) && !valor.equals(ECONOMICO)) {
			throw new ExcepcionTipoConsulta(mensaje);
		}
	}

}
