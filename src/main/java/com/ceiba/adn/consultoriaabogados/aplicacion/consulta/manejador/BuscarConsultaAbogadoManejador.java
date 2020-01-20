package com.ceiba.adn.consultoriaabogados.aplicacion.consulta.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.servicio.BuscarConsultaAbogadoServicio;

@Component
public class BuscarConsultaAbogadoManejador {
	private final BuscarConsultaAbogadoServicio buscarConsultaAbogadoServicio;

	public BuscarConsultaAbogadoManejador(BuscarConsultaAbogadoServicio buscarConsultaAbogadoServicio) {
		this.buscarConsultaAbogadoServicio = buscarConsultaAbogadoServicio;
	}

	public ListarConsultaAbogado ejecutar(Long id) {
		return this.buscarConsultaAbogadoServicio.buscarConsultaAbogado(id);
	}
}
