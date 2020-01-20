package com.ceiba.adn.consultoriaabogados.dominio.excepcion;

public class ExcepcionFormatoFecha extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFormatoFecha(String mensaje) {
		super(mensaje);
	}

}
