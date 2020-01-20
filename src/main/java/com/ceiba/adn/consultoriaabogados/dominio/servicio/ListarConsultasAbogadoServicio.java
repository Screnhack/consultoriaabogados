package com.ceiba.adn.consultoriaabogados.dominio.servicio;

import java.util.List;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;

public class ListarConsultasAbogadoServicio {
	private ConsultaAbogadoRepositorio consultaAbogadoRepositorio;

	public ListarConsultasAbogadoServicio(ConsultaAbogadoRepositorio consultaAbogadoRepositorio) {
		this.consultaAbogadoRepositorio = consultaAbogadoRepositorio;
	}

	public List<ListarConsultaAbogado> listarConsultasAbogado() {
		return this.consultaAbogadoRepositorio.listarConsultasAbogado();
	}
}
