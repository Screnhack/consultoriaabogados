package com.ceiba.adn.consultoriaabogados.aplicacion.consulta;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListarConsultaAbogado {
	private Long id;
	private String nombre;
	private String identificacion;
	private String celular;
	private String tipoConsultoria;
	private String estado;
	private String fechaConsulta;

	public ListarConsultaAbogado(Long id, String nombre, String identificacion, String celular, String tipoConsultoria,
			String estado, Date fechaConsulta) {
		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.celular = celular;
		this.tipoConsultoria = tipoConsultoria;
		this.estado = estado;
		this.fechaConsulta = formatearFechaString(fechaConsulta);
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

	public String getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public String formatearFechaString(Date fechaConsulta) {
		SimpleDateFormat formatearFecha = new SimpleDateFormat("yyyy-MM-dd");
		return formatearFecha.format(fechaConsulta);
	}
}
