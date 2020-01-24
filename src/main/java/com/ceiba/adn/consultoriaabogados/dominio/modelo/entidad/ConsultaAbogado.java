package com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad;

import java.util.Date;

import com.ceiba.adn.consultoriaabogados.dominio.util.FormatearFechas;
import com.ceiba.adn.consultoriaabogados.dominio.validador.ValidadorArgumentos;

public class ConsultaAbogado {
	private FormatearFechas formatearFecha;

	private static final String NOMBRE_ESTA_VACIO = "Se debe ingresar el nombre del cliente";
	private static final String IDENTIFICACION_ESTA_VACIA = "Se debe ingresar la identificacion del cliente";
	private static final String FECHA_ESTA_VACIA = "Se debe registrar la fecha de la cita";
	private static final String ESTADO_INVALIDO = "Se debe ingresar un tipo de valido de estado";
	private static final String TIPO_DE_CONSULTA_INVALIDO = "Se debe ingresar un tipo valido de consulta";

	private Long id;
	private String nombre;
	private String identificacion;
	private String celular;
	private String tipoConsultoria;
	private String estado;
	private Date fechaConsulta;
	private float precio;

	public ConsultaAbogado(String nombre, String identificacion, String celular, String tipoConsultoria, String estado,
			String fecha) {
		ValidadorArgumentos.validarRequeridos(nombre, NOMBRE_ESTA_VACIO);
		ValidadorArgumentos.validarRequeridos(identificacion, IDENTIFICACION_ESTA_VACIA);
		ValidadorArgumentos.validarRequeridos(fecha, FECHA_ESTA_VACIA);
		ValidadorArgumentos.validarEstadosConsulta(estado, ESTADO_INVALIDO);
		ValidadorArgumentos.validarTipoConsulta(tipoConsultoria, TIPO_DE_CONSULTA_INVALIDO);
		this.formatearFecha = new FormatearFechas();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.celular = celular;
		this.tipoConsultoria = tipoConsultoria;
		this.estado = estado;
		this.fechaConsulta = formatearFecha.formatearFechaDate(fecha);
	}
	
}
