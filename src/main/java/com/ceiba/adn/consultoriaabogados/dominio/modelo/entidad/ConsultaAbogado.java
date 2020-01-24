package com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad;

import java.util.Date;

import com.ceiba.adn.consultoriaabogados.dominio.validador.ValidadorArgumentos;

public class ConsultaAbogado {

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
			Date fecha) {
		ValidadorArgumentos.validarRequeridos(nombre, NOMBRE_ESTA_VACIO);
		ValidadorArgumentos.validarRequeridos(identificacion, IDENTIFICACION_ESTA_VACIA);
		ValidadorArgumentos.validarRequeridos(fecha, FECHA_ESTA_VACIA);
		ValidadorArgumentos.validarEstadosConsulta(estado, ESTADO_INVALIDO);
		ValidadorArgumentos.validarTipoConsulta(tipoConsultoria, TIPO_DE_CONSULTA_INVALIDO);
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

}
