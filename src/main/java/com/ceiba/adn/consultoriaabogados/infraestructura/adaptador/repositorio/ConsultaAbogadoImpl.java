package com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;
import com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.entidad.ConsultaAbogadoEntidad;
import com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.mapeador.ConsultaAbogadoMapeador;

@Component
public class ConsultaAbogadoImpl implements ConsultaAbogadoRepositorio {

	private static final ConsultaAbogadoMapeador consultaAbogadoMapeador = ConsultaAbogadoMapeador.getInstance();

	private ConsultaAbogadoJpa consultaAbogadoJpa;

	public ConsultaAbogadoImpl(ConsultaAbogadoJpa consultaAbogadoJpa) {
		this.consultaAbogadoJpa = consultaAbogadoJpa;
	}

	@Override
	public ConsultaAbogado crearConsulta(ConsultaAbogado consultaAbogado) {
		ConsultaAbogadoEntidad entidadAbogado = consultaAbogadoMapeador.aEntidad(consultaAbogado);
		return consultaAbogadoMapeador.aDominio(consultaAbogadoJpa.save(entidadAbogado));
	}

	@Override
	public List<ListarConsultaAbogado> listarConsultasAbogado() {
		return consultaAbogadoJpa.listarConsultasAbogado();
	}

	@Override
	public ListarConsultaAbogado buscarConsultaAbogado(Long id) {
		return consultaAbogadoJpa.buscarConsulta(id);
	}

	@Override
	public boolean validarConsultasClienteDia(String identificacion, Date fechaConsulta) {
		return consultaAbogadoJpa.validarConsultasClienteDia(identificacion, fechaConsulta) > 0;
	}

}
