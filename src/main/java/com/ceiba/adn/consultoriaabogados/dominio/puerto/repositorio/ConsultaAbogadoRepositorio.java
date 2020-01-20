package com.ceiba.adn.consultoriaabogados.dominio.puerto.repositorio;

import java.util.Date;
import java.util.List;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad.ConsultaAbogado;

public interface ConsultaAbogadoRepositorio {

	/**
	 * Método que lista todas las consultas que fueron creadas
	 * 
	 * @return consultas
	 */
	public List<ListarConsultaAbogado> listarConsultasAbogado();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ListarConsultaAbogado buscarConsultaAbogado(Long id);

	/**
	 * Método que verifica si el cliente ya tiene una cita para ese dia
	 * 
	 * @param identificacion Identificacion del cliente
	 * @param 	  Fecha de la consulta solicitada por el cliente
	 * @return boolean con respuesta si el cliente ya tiene cita para ese dia
	 */
	public boolean validarConsultasClienteDia(String identificacion, Date fechaConsulta);

	/**
	 * Método que registra una nueva consulta
	 * 
	 * @param consulta a registrar
	 * @return consulta registrada en la base de datos con sus respectivos datos
	 */
	public ConsultaAbogado crearConsulta(ConsultaAbogado consultaAbogado);

}
