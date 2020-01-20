package com.ceiba.adn.consultoriaabogados.dominio.excepcion;

public class ExcepcionEstadoInvalido extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExcepcionEstadoInvalido(String mensaje) {
		super(mensaje);
	}
}
