package com.ceiba.adn.consultoriaabogados.aplicacion.comando;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsultaAbogadoComando {
	private String nombre;
	private String identificacion;
	private String celular;
	private String tipoConsultoria;
	private String estado;
	private Date fechaConsulta;
	private float precio;

}
