package com.ceiba.adn.consultoriaabogados.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.servicio.ListarConsultasAbogadoServicio;

@Component
public class ListarConsultasAbogadoManejador {

	private final ListarConsultasAbogadoServicio listarConsultasAbogadoServicio;

	public ListarConsultasAbogadoManejador(ListarConsultasAbogadoServicio listarConsultasAbogadoServicio) {
		this.listarConsultasAbogadoServicio = listarConsultasAbogadoServicio;
	}

	public List<ListarConsultaAbogado> ejecutar() {
		return this.listarConsultasAbogadoServicio.listarConsultasAbogado();
	}

}
