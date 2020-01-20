package com.ceiba.adn.consultoriaabogados.dominio.excepcion;

public class ExcepcionClienteConsultaDia extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionClienteConsultaDia(String mensaje) {
		super(mensaje);
	}

}
