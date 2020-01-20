package com.ceiba.adn.consultoriaabogados.dominio.excepcion;

public class ExcepcionNoExisteConsultaAbogado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionNoExisteConsultaAbogado(String mensaje) {
		super(mensaje);
	}

}
