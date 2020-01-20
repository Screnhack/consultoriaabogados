package com.ceiba.adn.consultoriaabogados.dominio.excepcion;

public class ExcepcionDiaProhibidos extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionDiaProhibidos(String mensaje) {
		super(mensaje);
	}

}
