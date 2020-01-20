package com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.mapeador;

import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.entidad.ConsultaAbogadoEntidad;

public final class ConsultaAbogadoMapeador {

	private ConsultaAbogadoMapeador() {
	}

	private static final ConsultaAbogadoMapeador INSTANCE = new ConsultaAbogadoMapeador();

	public static ConsultaAbogadoMapeador getInstance() {
		return INSTANCE;
	}

	public ConsultaAbogado aDominio(ConsultaAbogadoEntidad entidadAbogado) {
		ConsultaAbogado dominio = new ConsultaAbogado();
		dominio.setId(entidadAbogado.getId());
		dominio.setNombre(entidadAbogado.getNombre());
		dominio.setIdentificacion(entidadAbogado.getIdentificacion());
		dominio.setCelular(entidadAbogado.getCelular());
		dominio.setTipoConsultoria(entidadAbogado.getTipoConsultoria());
		dominio.setEstado(entidadAbogado.getEstado());
		dominio.setPrecio(entidadAbogado.getPrecio());
		dominio.setFechaConsulta(entidadAbogado.getFechaConsulta());
		return dominio;
	}

	public ConsultaAbogadoEntidad aEntidad(ConsultaAbogado dominioAbogado) {
		ConsultaAbogadoEntidad entidad = new ConsultaAbogadoEntidad();
		entidad.setId(dominioAbogado.getId());
		entidad.setNombre(dominioAbogado.getNombre());
		entidad.setIdentificacion(dominioAbogado.getIdentificacion());
		entidad.setCelular(dominioAbogado.getCelular());
		entidad.setTipoConsultoria(dominioAbogado.getTipoConsultoria());
		entidad.setEstado(dominioAbogado.getEstado());
		entidad.setPrecio(dominioAbogado.getPrecio());
		entidad.setFechaConsulta(dominioAbogado.getFechaConsulta());
		return entidad;
	}
}
