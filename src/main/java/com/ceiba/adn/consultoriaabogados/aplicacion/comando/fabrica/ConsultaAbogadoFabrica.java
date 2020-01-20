package com.ceiba.adn.consultoriaabogados.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;

@Component
public class ConsultaAbogadoFabrica {

	public ConsultaAbogado crearConsulta(ConsultaAbogadoComando comandoConsultaAbogado) {
		return new ConsultaAbogado(comandoConsultaAbogado.getNombre(), comandoConsultaAbogado.getIdentificacion(),
				comandoConsultaAbogado.getCelular(), comandoConsultaAbogado.getTipoConsultoria(),
				comandoConsultaAbogado.getEstado(), comandoConsultaAbogado.getFechaConsulta());
	}

}
