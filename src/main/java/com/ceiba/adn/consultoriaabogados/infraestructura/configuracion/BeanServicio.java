package com.ceiba.adn.consultoriaabogados.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio.ConsultaAbogadoRepositorio;
import com.ceiba.adn.consultoriaabogados.dominio.servicio.BuscarConsultaAbogadoServicio;
import com.ceiba.adn.consultoriaabogados.dominio.servicio.CrearConsultaAbogadoServicio;
import com.ceiba.adn.consultoriaabogados.dominio.servicio.ListarConsultasAbogadoServicio;

@Configuration
public class BeanServicio {

	@Bean
	public CrearConsultaAbogadoServicio servicioCrearConsultaAbogado(
			ConsultaAbogadoRepositorio consultaAbogadoRepositorio) {
		return new CrearConsultaAbogadoServicio(consultaAbogadoRepositorio);
	}

	@Bean
	public ListarConsultasAbogadoServicio listarConsultasAbogadoServicio(
			ConsultaAbogadoRepositorio consultaAbogadoRepositorio) {
		return new ListarConsultasAbogadoServicio(consultaAbogadoRepositorio);
	}

	@Bean
	public BuscarConsultaAbogadoServicio buscarConsultaAbogadoServicio(
			ConsultaAbogadoRepositorio consultaAbogadoRepositorio) {
		return new BuscarConsultaAbogadoServicio(consultaAbogadoRepositorio);
	}
}
