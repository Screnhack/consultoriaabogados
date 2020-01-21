package com.ceiba.adn.consultoriaabogados.aplicacion.comando;

public class ConsultaAbogadoComando {
	private String nombre;
	private String identificacion;
	private String celular;
	private String tipoConsultoria;
	private String estado;
	private String fechaConsulta;
	private float precio;

	public String getNombre() {
		return nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public String getCelular() {
		return celular;
	}

	public String getTipoConsultoria() {
		return tipoConsultoria;
	}

	public String getEstado() {
		return estado;
	}

	public String getFechaConsulta() {
		return fechaConsulta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setTipoConsultoria(String tipoConsultoria) {
		this.tipoConsultoria = tipoConsultoria;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
