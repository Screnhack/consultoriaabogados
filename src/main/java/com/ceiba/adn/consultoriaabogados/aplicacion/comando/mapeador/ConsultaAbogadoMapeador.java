package com.ceiba.adn.consultoriaabogados.aplicacion.comando.mapeador;

import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.util.FormatearFechas;

public final class ConsultaAbogadoMapeador {
	private FormatearFechas formatearFecha;
	
	private ConsultaAbogadoMapeador() {
		this.formatearFecha = new FormatearFechas();
	}

	private static final ConsultaAbogadoMapeador INSTANCE = new ConsultaAbogadoMapeador();

	public static ConsultaAbogadoMapeador getInstance() {
		return INSTANCE;
	}

	public ConsultaAbogadoComando aComando(ConsultaAbogado entidad) {
		ConsultaAbogadoComando dominio = new ConsultaAbogadoComando();
		dominio.setNombre(entidad.getNombre());
		dominio.setIdentificacion(entidad.getIdentificacion());
		dominio.setCelular(entidad.getCelular());
		dominio.setTipoConsultoria(entidad.getTipoConsultoria());
		dominio.setEstado(entidad.getEstado());
		dominio.setFechaConsulta(entidad.getFechaConsulta());
		dominio.setPrecio(entidad.getPrecio());
		return dominio;
	}
}
