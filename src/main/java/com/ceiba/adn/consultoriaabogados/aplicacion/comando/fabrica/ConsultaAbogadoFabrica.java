package com.ceiba.adn.consultoriaabogados.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;

@Component
public class ConsultaAbogadoFabrica {

	public ConsultaAbogado crearConsulta(ConsultaAbogadoComando consultaAbogadoComando) {
		return new ConsultaAbogado(consultaAbogadoComando.getNombre(), consultaAbogadoComando.getIdentificacion(),
				consultaAbogadoComando.getCelular(), consultaAbogadoComando.getTipoConsultoria(),
				consultaAbogadoComando.getEstado(), consultaAbogadoComando.getFechaConsulta());
	}

}
