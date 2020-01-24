package com.ceiba.adn.consultoriaabogados.dominio.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionFormatoFecha;

public class FormatearFechas {

	private static final String FORMATO_FECHA_INVALIDO = "Formato de fecha Invalido";

	public String formatearFechaString(Date fechaConsulta) {
		SimpleDateFormat formatearFecha = new SimpleDateFormat("dd/MM/yyyy");
		return formatearFecha.format(fechaConsulta);
	}

	public Date formatearFechaDate(String fechaConsulta) {
		try {
			SimpleDateFormat formatearFecha = new SimpleDateFormat("dd/MM/yyyy");
			return formatearFecha.parse(fechaConsulta);
		} catch (Exception e) {
			throw new ExcepcionFormatoFecha(FORMATO_FECHA_INVALIDO);
		}
	}

}
