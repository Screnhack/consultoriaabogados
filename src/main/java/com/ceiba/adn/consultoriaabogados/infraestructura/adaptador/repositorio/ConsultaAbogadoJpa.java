package com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.entidad.ConsultaAbogadoEntidad;

public interface ConsultaAbogadoJpa extends CrudRepository<ConsultaAbogadoEntidad, Long> {

	@Query("select new com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado(con.id, con.nombre, con.identificacion, con.celular, con.tipoConsultoria, con.estado, con.fechaConsulta) from ConsultaAbogadoEntidad con ")
	List<ListarConsultaAbogado> listarConsultasAbogado();

	@Query("select new com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado(con.id, con.nombre, con.identificacion, con.celular, con.tipoConsultoria, con.estado, con.fechaConsulta)  from ConsultaAbogadoEntidad con where con.id = :id")
	ListarConsultaAbogado buscarConsulta(@Param("id") Long id);
	
	@Query("select count(*)  from ConsultaAbogadoEntidad con where con.identificacion = :identificacion and con.fechaConsulta = :fecha")
	long validarConsultasClienteDia(@Param("identificacion") String identificacion, @Param("fecha") Date fechaConsulta);
}
