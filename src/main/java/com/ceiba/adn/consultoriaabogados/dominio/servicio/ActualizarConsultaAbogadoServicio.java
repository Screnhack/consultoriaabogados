package com.ceiba.adn.consultoriaabogados.dominio.servicio;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionNoExisteConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;

public class ActualizarConsultaAbogadoServicio {

	private ConsultaAbogadoRepositorio consultaAbogadoRepositorio;
	private static final String CONSULTA_ABOGADO_NO_EXISTE = "No se encontró la consulta en base de datos";

	public ActualizarConsultaAbogadoServicio(ConsultaAbogadoRepositorio consultaAbogadoRepositorio) {
		this.consultaAbogadoRepositorio = consultaAbogadoRepositorio;
	}

	public ConsultaAbogado actualizarConsultaAbogado(ConsultaAbogado consultaAbogado) {
		consultaAbogado.validarIdConsulta();
		if (validarConsultaAbogadoExiste(consultaAbogado.getId()) != null) {
			consultaAbogado.validarConsultaDiaDomingo();
			consultaAbogado.precioTipoConsulta();
			return this.consultaAbogadoRepositorio.crearConsulta(consultaAbogado);
		} else {
			throw new ExcepcionNoExisteConsultaAbogado(CONSULTA_ABOGADO_NO_EXISTE);
		}
	}

	public ListarConsultaAbogado validarConsultaAbogadoExiste(long id) {
		return this.consultaAbogadoRepositorio.buscarConsultaAbogado(id);
	}
}
