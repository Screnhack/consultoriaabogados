package com.ceiba.adn.consultoriaabogados.aplicacion.comando.mapeador;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;

public final class ConsultaAbogadoMapeador {
	private ConsultaAbogadoMapeador() {
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
		dominio.setFechaConsulta(formatearFechaString(entidad.getFechaConsulta()));
		dominio.setPrecio(entidad.getPrecio());
		return dominio;
	}

	public String formatearFechaString(Date fechaConsulta) {
		SimpleDateFormat formatearFecha = new SimpleDateFormat("yyyy-MM-dd");
		return formatearFecha.format(fechaConsulta);
	}
}
