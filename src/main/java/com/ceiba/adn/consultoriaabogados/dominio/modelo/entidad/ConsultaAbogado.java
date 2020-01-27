package com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionDiaProhibidos;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionTipoConsulta;
import com.ceiba.adn.consultoriaabogados.dominio.validador.ValidadorArgumentos;

public class ConsultaAbogado {

	private static final String NOMBRE_ESTA_VACIO = "Se debe ingresar el nombre del cliente";
	private static final String IDENTIFICACION_ESTA_VACIA = "Se debe ingresar la identificacion del cliente";
	private static final String FECHA_ESTA_VACIA = "Se debe registrar la fecha de la cita";
	private static final String ESTADO_INVALIDO = "Se debe ingresar un tipo de valido de estado";
	private static final String TIPO_DE_CONSULTA_INVALIDO = "Se debe ingresar un tipo valido de consulta";
	private static final String ID_CONSULTA_ES_VACIA = "Se debe ingresar el id de la consulta";
	private static final String DIA_DOMINGO = "El Domingo no se pueden agendar citas";
	private static final String DIA_LUNES = "El lunes no se pueden agendar citas de tipo judicial";
	private static final double PROCENTAJE_AUMENTO_SABADO = 0.5;

	private Long id;
	private String nombre;
	private String identificacion;
	private String celular;
	private String tipoConsultoria;
	private String estado;
	private Date fechaConsulta;
	private float precio;

	public ConsultaAbogado(Long id, String nombre, String identificacion, String celular, String tipoConsultoria,
			String estado, Date fecha) {
		ValidadorArgumentos.validarRequeridos(nombre, NOMBRE_ESTA_VACIO);
		ValidadorArgumentos.validarRequeridos(identificacion, IDENTIFICACION_ESTA_VACIA);
		ValidadorArgumentos.validarRequeridos(fecha, FECHA_ESTA_VACIA);
		ValidadorArgumentos.validarEstadosConsulta(estado, ESTADO_INVALIDO);
		ValidadorArgumentos.validarTipoConsulta(tipoConsultoria, TIPO_DE_CONSULTA_INVALIDO);
		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.celular = celular;
		this.tipoConsultoria = tipoConsultoria;
		this.estado = estado;
		this.fechaConsulta = fecha;
	}

	public ConsultaAbogado() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipoConsultoria() {
		return tipoConsultoria;
	}

	public void setTipoConsultoria(String tipoConsultoria) {
		this.tipoConsultoria = tipoConsultoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void validarIdConsulta() {
		ValidadorArgumentos.validarRequeridos(id, ID_CONSULTA_ES_VACIA);
	}

	public void validarConsultaDiaDomingo(Date fechaConsulta) {
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaConsulta);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == Calendar.SUNDAY) {
			throw new ExcepcionDiaProhibidos(DIA_DOMINGO);
		}
	}

	public Boolean validarConsultaDiaSabado(Date fechaConsulta) {
		boolean respuesta = false;
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaConsulta);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == Calendar.SATURDAY) {
			respuesta = true;
		}
		return respuesta;
	}

	public void validarConsultaDiaLunesJudicial(Date fechaConsulta) {
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaConsulta);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == Calendar.MONDAY) {
			throw new ExcepcionDiaProhibidos(DIA_LUNES);
		}
	}

	public void precioTipoConsulta() {
		switch (tipoConsultoria) {
		case "FAMILIAR":
			precio = 100000;
			break;
		case "JUDICIAL":
			validarConsultaDiaLunesJudicial(fechaConsulta);
			precio = 200000;
			break;
		case "ECONOMICO":
			precio = 110000;
			break;
		default:
			throw new ExcepcionTipoConsulta(TIPO_DE_CONSULTA_INVALIDO);
		}
		boolean aumento = validarConsultaDiaSabado(fechaConsulta);
		if (aumento) {
			precio = (float) (precio + (precio * PROCENTAJE_AUMENTO_SABADO));
		}
	}

}
