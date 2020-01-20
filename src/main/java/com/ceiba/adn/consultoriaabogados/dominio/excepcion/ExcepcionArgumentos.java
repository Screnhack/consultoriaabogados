package com.ceiba.adn.consultoriaabogados.dominio.excepcion;

public class ExcepcionArgumentos extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionArgumentos(String mensaje) {
		super(mensaje);
	}
}
