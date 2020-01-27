package com.ceiba.adn.consultoriaabogados.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ComandoRespuesta;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.fabrica.ConsultaAbogadoFabrica;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.manejador.respuesta.ManejadorComandoRespuesta;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.mapeador.ConsultaAbogadoMapeador;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.servicio.ActualizarConsultaAbogadoServicio;

@Component
public class ActualizarConsultaAbogadoManejador
		implements ManejadorComandoRespuesta<ConsultaAbogadoComando, ComandoRespuesta<ConsultaAbogadoComando>> {

	private final ConsultaAbogadoFabrica consultaAbogadoFabrica;
	private final ActualizarConsultaAbogadoServicio actualizarConsultaAbogadoServicio;
	private static final ConsultaAbogadoMapeador mapeador = ConsultaAbogadoMapeador.getInstance();

	public ActualizarConsultaAbogadoManejador(ConsultaAbogadoFabrica consultaAbogadoFabrica,
			ActualizarConsultaAbogadoServicio actualizarConsultaAbogadoServicio) {
		this.consultaAbogadoFabrica = consultaAbogadoFabrica;
		this.actualizarConsultaAbogadoServicio = actualizarConsultaAbogadoServicio;
	}

	@Override
	public ComandoRespuesta<ConsultaAbogadoComando> ejecutar(ConsultaAbogadoComando comandoConsultaAbogado) {
		ConsultaAbogado consultaAbogado = this.consultaAbogadoFabrica.crearConsulta(comandoConsultaAbogado);
		return new ComandoRespuesta<>(
				mapeador.aComando(this.actualizarConsultaAbogadoServicio.actualizarConsultaAbogado(consultaAbogado)));
	}

}
