package com.ceiba.adn.consultoriaabogados.dominio.servicio;

import java.util.Date;

import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionClienteConsultaDia;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;

public class CrearConsultaAbogadoServicio {
	private ConsultaAbogadoRepositorio consultaAbogadoRepositorio;
	private static final String CLIENTE_CONLSULTA_DIA_EXISTE = "El Cliente ya tiene cita para el dia seleccionado";

	public CrearConsultaAbogadoServicio(ConsultaAbogadoRepositorio consultaAbogadoRepositorio) {
		this.consultaAbogadoRepositorio = consultaAbogadoRepositorio;
	}

	public ConsultaAbogado ejecutar(ConsultaAbogado consultaAbogado) {
		consultaAbogado.validarConsultaDiaDomingo(consultaAbogado.getFechaConsulta());
		consultaAbogado.precioTipoConsulta();
		validarConsultasClienteDia(consultaAbogado.getIdentificacion(), consultaAbogado.getFechaConsulta());
		return this.consultaAbogadoRepositorio.crearConsulta(consultaAbogado);
	}

	public void validarConsultasClienteDia(String identificacion, Date fechaConsulta) {
		if (this.consultaAbogadoRepositorio.validarConsultasClienteDia(identificacion, fechaConsulta)) {
			throw new ExcepcionClienteConsultaDia(CLIENTE_CONLSULTA_DIA_EXISTE);
		}
	}

}
