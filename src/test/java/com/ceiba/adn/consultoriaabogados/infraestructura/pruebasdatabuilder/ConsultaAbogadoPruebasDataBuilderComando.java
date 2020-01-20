package com.ceiba.adn.consultoriaabogados.infraestructura.pruebasdatabuilder;

import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;

public class ConsultaAbogadoPruebasDataBuilderComando {
	private String nombre;
	private String identificacion;
	private String celular;
	private String tipoConsultoria;
	private String estado;
	private String fechaConsulta;

	public ConsultaAbogadoPruebasDataBuilderComando() {
	}

	public ConsultaAbogadoPruebasDataBuilderComando conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ConsultaAbogadoPruebasDataBuilderComando conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public ConsultaAbogadoPruebasDataBuilderComando conCelular(String celular) {
		this.celular = celular;
		return this;
	}

	public ConsultaAbogadoPruebasDataBuilderComando conTipoConsultoria(String tipoConsultoria) {
		this.tipoConsultoria = tipoConsultoria;
		return this;
	}

	public ConsultaAbogadoPruebasDataBuilderComando conEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public ConsultaAbogadoPruebasDataBuilderComando conFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
		return this;
	}

	public ConsultaAbogadoComando build() {
		ConsultaAbogadoComando consultaAbogadoComando = new ConsultaAbogadoComando();
		consultaAbogadoComando.setNombre(this.nombre);
		consultaAbogadoComando.setIdentificacion(this.identificacion);
		consultaAbogadoComando.setCelular(this.celular);
		consultaAbogadoComando.setTipoConsultoria(this.tipoConsultoria);
		consultaAbogadoComando.setEstado(this.estado);
		consultaAbogadoComando.setFechaConsulta(this.fechaConsulta);
		return consultaAbogadoComando;
	}
}
