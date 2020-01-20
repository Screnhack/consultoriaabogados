package com.ceiba.adn.consultoriaabogados.dominio.servicio;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionNoExisteConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;

public class BuscarConsultaAbogadoServicio {
	private ConsultaAbogadoRepositorio consultaAbogadoRepositorio;
	private static final String CONSULTA_ABOGADO_NO_EXISTE = "No Existe la consulta de abogado que se esta buscando";
	
	public BuscarConsultaAbogadoServicio(ConsultaAbogadoRepositorio consultaAbogadoRepositorio) {
		this.consultaAbogadoRepositorio = consultaAbogadoRepositorio;
	}

	public ListarConsultaAbogado buscarConsultaAbogado(Long id) {
		if( this.consultaAbogadoRepositorio.buscarConsultaAbogado(id) == null)
		{
			throw new ExcepcionNoExisteConsultaAbogado(CONSULTA_ABOGADO_NO_EXISTE);
		}
		return this.consultaAbogadoRepositorio.buscarConsultaAbogado(id);
	}
}
