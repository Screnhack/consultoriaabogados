package com.ceiba.adn.consultoriaabogados.dominio.databuilder;

import java.util.Date;

import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;

public class ConsultaAbogadoPruebaDataBuilder {

	private String nombre;
	private String identificacion;
	private String celular;
	private String tipoConsultoria;
	private String estado;
	private Date fechaConsulta;

	public ConsultaAbogadoPruebaDataBuilder() {
	}

	public ConsultaAbogadoPruebaDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ConsultaAbogadoPruebaDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public ConsultaAbogadoPruebaDataBuilder conCelular(String celular) {
		this.celular = celular;
		return this;
	}

	public ConsultaAbogadoPruebaDataBuilder conTipoConsultoria(String tipoConsultoria) {
		this.tipoConsultoria = tipoConsultoria;
		return this;
	}

	public ConsultaAbogadoPruebaDataBuilder conEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public ConsultaAbogadoPruebaDataBuilder conFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
		return this;
	}

	public ConsultaAbogado build() {
		ConsultaAbogado consultaAbogado = new ConsultaAbogado();
		consultaAbogado.setNombre(this.nombre);
		consultaAbogado.setIdentificacion(this.identificacion);
		consultaAbogado.setCelular(this.celular);
		consultaAbogado.setTipoConsultoria(this.tipoConsultoria);
		consultaAbogado.setEstado(this.estado);
		consultaAbogado.setFechaConsulta(this.fechaConsulta);
		return consultaAbogado;

	}

}
