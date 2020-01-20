package com.ceiba.adn.consultoriaabogados.dominio.excepcion;

public class ExcepcionTipoConsulta extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExcepcionTipoConsulta(String mensaje) {
		super(mensaje);
	}
}
