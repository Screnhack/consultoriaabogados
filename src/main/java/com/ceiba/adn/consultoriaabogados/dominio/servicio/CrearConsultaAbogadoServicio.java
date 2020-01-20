package com.ceiba.adn.consultoriaabogados.dominio.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionClienteConsultaDia;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionDiaProhibidos;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionTipoConsulta;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;

public class CrearConsultaAbogadoServicio {
	private ConsultaAbogadoRepositorio consultaAbogadoRepositorio;
	private static final String CLIENTE_CONLSULTA_DIA_EXISTE = "El Cliente ya tiene cita para el dia seleccionado";
	private static final String DIA_DOMINGO = "El Domingo no se pueden agendar citas";
	private static final String DIA_LUNES = "El lunes no se pueden agendar citas de tipo judicial";
	private static final String TIPO_DE_CONSULTA_INVALIDO = "Se debe ingresar un tipo valido de consulta";

	public CrearConsultaAbogadoServicio(ConsultaAbogadoRepositorio consultaAbogadoRepositorio) {
		this.consultaAbogadoRepositorio = consultaAbogadoRepositorio;
	}

	public ConsultaAbogado ejecutar(ConsultaAbogado consultaAbogado) {
		validarConsultaDiaDomingo(consultaAbogado.getFechaConsulta());
		consultaAbogado.setPrecio(
				precioTipoConsulta(consultaAbogado.getTipoConsultoria(), consultaAbogado.getFechaConsulta()));
		validarConsultasClienteDia(consultaAbogado.getIdentificacion(), consultaAbogado.getFechaConsulta());
		return this.consultaAbogadoRepositorio.crearConsulta(consultaAbogado);
	}

	public void validarConsultaDiaDomingo(Date fechaConsulta) {
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaConsulta);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == Calendar.SUNDAY) {
			throw new ExcepcionDiaProhibidos(DIA_DOMINGO);
		}
	}

	public Boolean validarConsultaDiaSabado(Date fechaConsulta) {
		boolean respuesta = false;
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaConsulta);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == Calendar.SATURDAY) {
			respuesta = true;
		}
		return respuesta;
	}

	public void validarConsultaDiaLunesJudicial(Date fechaConsulta) {
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaConsulta);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == Calendar.MONDAY) {
			throw new ExcepcionDiaProhibidos(DIA_LUNES);
		}
	}

	public float precioTipoConsulta(String tipoConsulta, Date fechaConsulta) {
		float precio = 0;
		float precioTotalConsulta = 0;
		switch (tipoConsulta) {
		case "FAMILIAR":
			precio = 100000;
			break;
		case "JUDICIAL":
			validarConsultaDiaLunesJudicial(fechaConsulta);
			precio = 200000;
			break;
		case "ECONOMICO":
			precio = 110000;
			break;
		default:
			throw new ExcepcionTipoConsulta(TIPO_DE_CONSULTA_INVALIDO);
		}
		boolean aumento = validarConsultaDiaSabado(fechaConsulta);
		if (aumento) {
			precioTotalConsulta = precio + ((precio * 50) / 100);
		} else {
			precioTotalConsulta = precio;
		}
		return precioTotalConsulta;
	}

	public void validarConsultasClienteDia(String identificacion, Date fechaConsulta) {
		if (this.consultaAbogadoRepositorio.validarConsultasClienteDia(identificacion, fechaConsulta)) {
			throw new ExcepcionClienteConsultaDia(CLIENTE_CONLSULTA_DIA_EXISTE);
		}
	}

}
