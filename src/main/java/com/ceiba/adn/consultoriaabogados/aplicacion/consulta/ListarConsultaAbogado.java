package com.ceiba.adn.consultoriaabogados.aplicacion.consulta;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ListarConsultaAbogado {
	private Long id;
	private String nombre;
	private String identificacion;
	private String celular;
	private String tipoConsultoria;
	private String estado;
	private Date fechaConsulta;
	
}
